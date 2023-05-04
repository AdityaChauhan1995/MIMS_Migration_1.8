package com.maxis.order;

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

import com.maxis.constant.CommonUtil;
import com.maxis.constant.Constant;
import com.maxis.constant.LogUtil;
import com.maxis.db.AuditTrail;
import com.maxis.db.PhoneOrder;
import com.maxis.db.TransPhoneOrderReg;
import com.maxis.log.DeliveryConfirmationLogUtil;

public class DeliveryConfirmationServlet
extends HttpServlet
{
	protected Log log = LogFactory.getLog(DeliveryConfirmationServlet.class);
	private static String message = "Error During Delivery Confirmation Servlet Processing";
         boolean flagInsert = false;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		try
		{
	  DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING inString ======= " );

			//String input=request.getParameter("input");
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

      DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING inString ======= " + inString);

			StringTokenizer st = new StringTokenizer(inString, "|");
			List list = new Vector();
			while (st.hasMoreElements())
			{
				String token = st.nextElement().toString();
				DeliveryConfirmationLogUtil.info("token = " + token);
				list.add(token);
			}
			String orderId = (String)list.get(0);
			String imei = (String)list.get(3);

			DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING orderId ======= " + orderId);

			String newOrderId=null;
			if(orderId.contains("RRFEI") || orderId.contains("RRFSI")){
				newOrderId = orderId.substring(5, orderId.length());
			}
			else{
				newOrderId = orderId.substring(4, orderId.length());
			}
			// String newOrderId = orderId.substring(4, orderId.length());

      DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING OrderNo ======= " + newOrderId);
      DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING imei ======= " + imei);

      Date dateCreated = new Date(System.currentTimeMillis());

      PhoneOrder phoneOrder = new PhoneOrder();
      phoneOrder.setDeliveryStatusId(new Integer(9));
      phoneOrder.setDeliveryRemark("Delivery confirmation from Brightstar");
      phoneOrder.setDeliveyDateTime(dateCreated);
      phoneOrder.setImei(imei);
      phoneOrder.setOrderNo(new Integer(newOrderId));

      boolean rtnFlag = false;
      boolean rtnFlagAudit = false;
      boolean rtnRegStatusFlag = false;
      boolean rtnUptdFlag = false;
      Integer prodRegGrpMapId = CommonUtil.getProdRegGrpMapId(new Integer(newOrderId));
      //code start when order is not of type mdrive plug and play
      if ((orderId != null) && (orderId.length() > 0)) {
    	  if (!(prodRegGrpMapId != null && prodRegGrpMapId == 71)){
    		  rtnFlag = UpdateDeliveryConfirmation.updateDeliveryConfirmation(phoneOrder);
    	 
        
        DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING TransPhoneOrder update Status ======= " + rtnFlag);
      

      if(phoneOrder.getDeliveryStatusId().intValue() == 9){
    	  TransPhoneOrderReg transPhoneOrderReg = UpdateDeliveryConfirmation.getTransCompanySubscTxnsObj(newOrderId);

    	  if(null != transPhoneOrderReg && null != transPhoneOrderReg.getRegId()){
			  DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING PortalRegistrationStatus update Status ======= " + transPhoneOrderReg.getRegId());
    		  String delInProg = "DIPR";
    		  String remarks = "Order has been received by Brightstar Order No " + newOrderId + " after picking from stock";

    		  rtnRegStatusFlag = UpdateDeliveryConfirmation.insertIntoPortalRegistrationStatus(transPhoneOrderReg.getRegId(), delInProg, remarks);
    		  rtnUptdFlag = UpdateDeliveryConfirmation.updatePortalCompanySubscTxns(transPhoneOrderReg.getRegId(), delInProg, remarks);

    		  DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING insert Into PortalRegistrationStatus Status ======= " + rtnRegStatusFlag);
    		  DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING update PortalCompanySubscTxns Status ======= " + rtnUptdFlag);
    	  }
      }
		} else{
  		  rtnFlag = true;
  	  }
		}

      AuditTrail auditTrail = new AuditTrail();
      AuditTrail auditTrailSeq = new AuditTrail();
      Integer transMsidnFetch = null;
      String status =null;
       //code start for mdrive plug and play    
      if (prodRegGrpMapId != null && prodRegGrpMapId == 71){
    	   if(newOrderId!=null){
    	       transMsidnFetch = CommonUtil.getTransMsid(new Integer(newOrderId));
    	       status = CommonUtil.getStatusOfBrightStarTask(transMsidnFetch);
    			}
    	  if(rtnFlag && status.equalsIgnoreCase("In-Progress")){
    		  try{
    			  if(CommonUtil.validateImeiIccidMsisdn(imei)){
    			   boolean flag;
    			    flag = CommonUtil.updateTransServiceAttribute(new Integer(newOrderId),imei,Constant.sequenceNo);
    			    if(flag){
    			    	
    			    	flagInsert = CommonUtil.updateTransTask(new Integer(newOrderId),Constant.sequenceNo);
    			    	flagInsert = CommonUtil.insertTransTask(new Integer(newOrderId),Constant.sequenceNo1);
    			    }
    			   	
    			    UpdateDeliveryConfirmation.updateDeliveryConfirmation(phoneOrder);
    			    DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING TransPhoneOrder update Status ======= " + rtnFlag);
    			      

    			      if(phoneOrder.getDeliveryStatusId().intValue() == 9){
    			    	  TransPhoneOrderReg transPhoneOrderReg = UpdateDeliveryConfirmation.getTransCompanySubscTxnsObj(newOrderId);

    			    	  if(null != transPhoneOrderReg && null != transPhoneOrderReg.getRegId()){
    						  DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING PortalRegistrationStatus update Status ======= " + transPhoneOrderReg.getRegId());
    			    		  String delInProg = "DIPR";
    			    		  String remarks = "Order has been received by Brightstar Order No " + newOrderId + " after picking from stock";

    			    		  rtnRegStatusFlag = UpdateDeliveryConfirmation.insertIntoPortalRegistrationStatus(transPhoneOrderReg.getRegId(), delInProg, remarks);
    			    		  rtnUptdFlag = UpdateDeliveryConfirmation.updatePortalCompanySubscTxns(transPhoneOrderReg.getRegId(), delInProg, remarks);

    			    		  DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING insert Into PortalRegistrationStatus Status ======= " + rtnRegStatusFlag);
    			    		  DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING update PortalCompanySubscTxns Status ======= " + rtnUptdFlag);
    			    	  }
    			      }
    			  }
    		  }
    		  catch(Exception e){
    			  LogUtil.info("====== Exception Occured ========== "
    			  + e.getMessage()); 
    			  } 
    		  }
    	  }
      if (rtnFlag)
      {
        auditTrailSeq = UpdateDeliveryConfirmation.getAuditSeqNo_DeliveryConfirmation();

        DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING auditSeqNo ======= " + auditTrailSeq.getAuditSeqNo());

        auditTrail.setAuditId(auditTrailSeq.getAuditSeqNo());

        TransPhoneOrderReg transPhoneOrderReg = UpdateDeliveryConfirmation.getTransPhoneOrderRegObj(newOrderId);

        DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING Reg Id  ======= " + transPhoneOrderReg.getRegId());
        DeliveryConfirmationLogUtil.info("======= DeliveryConfirmationServlet STAGING Order No  ======= " + transPhoneOrderReg.getOrderNo());

        auditTrail.setRegId(transPhoneOrderReg.getRegId());
        auditTrail.setAccessBy("MIMS");
        auditTrail.setActivity("Order has been received by Brightstar Order No " + transPhoneOrderReg.getOrderNo() + " with IMEI# "+imei +" after picking from stock");
        auditTrail.setRemarks("Order has been received by Brightstar Order No " + transPhoneOrderReg.getOrderNo() + " with IMEI# "+imei + " after picking from stock");
        auditTrail.setAuditDate(dateCreated);
        auditTrail.setOrderNo(new Integer(newOrderId));

        rtnFlagAudit = UpdateDeliveryConfirmation.insertIntoAuditTrail_DeliveryConfirmation(auditTrail);
        DeliveryConfirmationLogUtil.info("======= InsertIntoAuditTrail STAGING rtnFlagAudit status ======= " + rtnFlagAudit);
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
        response.getWriter().print(message);
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
