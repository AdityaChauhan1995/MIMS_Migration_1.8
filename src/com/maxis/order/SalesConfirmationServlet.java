package com.maxis.order;

import com.maxis.db.AuditTrail;
import com.maxis.db.PhoneOrder;
import com.maxis.db.TransPhoneOrderReg;
import com.maxis.log.SalesConfirmationLogUtil;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SalesConfirmationServlet
  extends HttpServlet
{
  private static String message = "Error during Sales Confirmation Servlet processing";
  protected Log log = LogFactory.getLog(SalesConfirmationServlet.class);

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try
    {
      int len = request.getContentLength();
      byte[] input = new byte[len];

      ServletInputStream sin = request.getInputStream();
      int count = 0;
      int c;
      while ((c = sin.read(input, count, input.length - count)) != -1) {
        count += c;
      }
      sin.close();

      String inString = new String(input);

      SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING inString ======= " + inString);

      StringTokenizer st = new StringTokenizer(inString, "|");
      List list = new Vector();
      while (st.hasMoreElements())
      {
        String token = st.nextElement().toString();
        SalesConfirmationLogUtil.info("token = " + token);
        list.add(token);
      }
      String orderId = (String)list.get(0);
      String statusOK = (String)list.get(2);

      SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING orderId ======= " + orderId);
      SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING statusOK ======= " + statusOK);

      String newOrderId=null;
      if(orderId.contains("RRFEI") || orderId.contains("RRFSI")){
    	  newOrderId = orderId.substring(5, orderId.length());
      }
      else{
    	  newOrderId = orderId.substring(4, orderId.length());
      }
      
      SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING newOrderId ======= " + newOrderId);


      PhoneOrder phoneOrder = new PhoneOrder();
      phoneOrder.setOrderNo(new Integer(newOrderId));
      Date dateCreated = new Date(System.currentTimeMillis());
      phoneOrder.setDeliveryStatusId(new Integer(2));
      phoneOrder.setDeliveryRemark("Processing");
      phoneOrder.setDeliveyDateTime(dateCreated);

      boolean rtnFlag = false;
      boolean rtnFlagAudit = false;
      if ((orderId != null) && (orderId.length() > 0) && (statusOK.equalsIgnoreCase("OK")))
      {
        rtnFlag = UpdateDeliveryConfirmation.updateSalesConfirmation(phoneOrder);
        SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING TransPhoneOrder update Status ======= " + rtnFlag);
      }
      AuditTrail auditTrail = new AuditTrail();
      AuditTrail auditTrailSeq = new AuditTrail();
      if (rtnFlag)
      {
        auditTrailSeq = UpdateDeliveryConfirmation.getAuditSeqNo_Sales();

        SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING auditSeqNo ======= " + auditTrailSeq.getAuditSeqNo());

        auditTrail.setAuditId(auditTrailSeq.getAuditSeqNo());

        TransPhoneOrderReg transPhoneOrderReg = UpdateDeliveryConfirmation.getTransPhoneOrderRegObj(newOrderId);

        SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING Reg Id  ======= " + transPhoneOrderReg.getRegId());
        SalesConfirmationLogUtil.info("======= SalesConfirmationServlet STAGING Order No  ======= " + transPhoneOrderReg.getOrderNo());

        auditTrail.setRegId(transPhoneOrderReg.getRegId());
        auditTrail.setAccessBy("MIMS");
        auditTrail.setActivity("Order has been sent to BrightStar " + transPhoneOrderReg.getOrderNo());
        auditTrail.setRemarks("Order has been sent to BrightStar " + transPhoneOrderReg.getOrderNo());
        auditTrail.setAuditDate(dateCreated);
        auditTrail.setOrderNo(new Integer(newOrderId));

        rtnFlagAudit = UpdateDeliveryConfirmation.insertIntoAuditTrail_Sales(auditTrail);

        SalesConfirmationLogUtil.info("======= SalesConfirmationServlet insertIntoAuditTrail STAGING rtnFlagAudit status ======= " + rtnFlagAudit);
      }
      String responseStr = "1|OK";
      if ((orderId != null) && (orderId.length() > 0))
      {
        response.setStatus(200);
        OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());

        writer.write(responseStr);
        writer.flush();
        writer.close();
      }
      else
      {
        try
        {
          response.setStatus(400);
          response.getWriter().print(message);
          response.getWriter().close();
        }
        catch (IOException ioe)
        {
          ioe.getMessage();
        }
      }
    }
    catch (IOException e)
    {
      try
      {
        response.setStatus(400);
        response.getWriter().print(e.getMessage());
        response.getWriter().close();
      }
      catch (IOException ioe)
      {
        ioe.getMessage();
      }
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }
}
