package com.maxis.order;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.maxis.db.AuditTrail;
import com.maxis.db.PhoneOrder;
import com.maxis.db.TransMsisdn;
import com.maxis.db.TransPhoneOrderReg;
import com.maxis.log.DeliveredLogUtil;

public class DeliveredServlet
extends HttpServlet
{
	protected Log log = LogFactory.getLog(DeliveryConfirmationServlet.class);
	private static String message = "Error During Delivery Servlet Processing";
    private static String DATE_PATTERN = "MM/dd/yyyy hh:mm:ss a";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		try
		{
			int len = request.getContentLength();
			//String input=request.getParameter("input");
			DeliveredLogUtil.info("=======  DeliveredServlet STAGING start ======= ");

			int countInitial = 0;
			byte[] input = new byte[len];
			Date dateCreated = new Date(System.currentTimeMillis());
			boolean rtnFlag = false;

			ServletInputStream sin = request.getInputStream();
			int c;
			while ((c = sin.read(input, countInitial, input.length - countInitial)) != -1) {
				countInitial += c;
			}
			sin.close();

			String inString = new String(input);

			DeliveredLogUtil.info("======= DeliveredServlet STAGING inString ======= " + inString);



			StringTokenizer st = new StringTokenizer(inString, "|");
			List list = new Vector();
			while (st.hasMoreElements())
			{
				String token = st.nextElement().toString();
				DeliveredLogUtil.info("Token Params = " + token);
				list.add(token);
			}
			String orderId = (String)list.get(0);
			String salesDate = (String)list.get(1);
			String statusSD = (String)list.get(2);
			String delivSuccess = (String)list.get(3);

			DeliveredLogUtil.info("======= DeliveredServlet STAGING orderId ======= " + orderId);

			String newOrderId=null;
			if(orderId.contains("RRFEI") || orderId.contains("RRFSI")){
				newOrderId = orderId.substring(5, orderId.length());
			}
			else{
				newOrderId = orderId.substring(4, orderId.length());
			}
			//String newOrderId = orderId.substring(4, orderId.length());

			DeliveredLogUtil.info("======= DeliveredServlet STAGING newOrderId ======= " + newOrderId);
			DeliveredLogUtil.info("======= DeliveredServlet STAGING salesDate ======= " + salesDate);
			DeliveredLogUtil.info("======= DeliveredServlet STAGING statusSD ======= " + statusSD);
			DeliveredLogUtil.info("======= DeliveredServlet STAGING delivSuccess ======= " + delivSuccess);

			SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);

			String salesDateFromB = "";
			Date slDate = null;
			try
			{
				slDate = format.parse(salesDate);
				salesDateFromB = format.format(slDate);
				DeliveredLogUtil.info("======= DeliveredServlet STAGING salesDateFromB Parsed ======= " + salesDateFromB);
			}
			catch (ParseException e)
			{
				DeliveredLogUtil.info("======= DeliveredServlet STAGING ParseException Exxxxx ======= " + e.getMessage());
			}
			PhoneOrder phoneOrder = new PhoneOrder();
			phoneOrder.setOrderNo(new Integer(newOrderId));
			Integer prodRegGrpMapId = CommonUtil.getProdRegGrpMapId(new Integer(newOrderId));

			if(prodRegGrpMapId == null || prodRegGrpMapId!=71){
				if ((delivSuccess.equalsIgnoreCase("Success")) && (statusSD.equalsIgnoreCase("SD")))
				{
					phoneOrder.setDeliveryStatusId(new Integer(1));
					phoneOrder.setDeliveryRemark("Delivered from Brightstar");
				}
				if ((delivSuccess.equalsIgnoreCase("Cancel Order")) && (statusSD.equalsIgnoreCase("CC")))
				{
					phoneOrder.setDeliveryStatusId(new Integer(8));
					phoneOrder.setDeliveryRemark("Cancel Order from Brightstar");
				}
				if (statusSD.equalsIgnoreCase("FD"))
				{
					phoneOrder.setDeliveryStatusId(new Integer(8));
					phoneOrder.setDeliveryRemark("Failed Order from Brightstar");
				}
				phoneOrder.setDeliveyDateTime(slDate);
				/*phoneOrder.setDeliveyDateTime(dateCreated);*/


				if ((orderId != null) && (orderId.length() > 0) && (delivSuccess.equalsIgnoreCase("Success")) && (statusSD.equalsIgnoreCase("SD")))
				{
					rtnFlag = UpdateDeliveryConfirmation.updateDelivered(phoneOrder);
					DeliveredLogUtil.info("======= SD --> Success :: DeliveredServlet STAGING TransPhoneOrder update Status 1 (Delivered) ======= " + rtnFlag);
				}
				if ((orderId != null) && (orderId.length() > 0) && (delivSuccess.equalsIgnoreCase("Cancel Order")) && (statusSD.equalsIgnoreCase("CC")))
				{
					rtnFlag = UpdateDeliveryConfirmation.updateDelivered(phoneOrder);
					DeliveredLogUtil.info("======= CC --> Cancel Order :: DeliveredServlet STAGING TransPhoneOrder update Status 8 (Failed) ======= " + rtnFlag);
				}
				if ((orderId != null) && (orderId.length() > 0) && (statusSD.equalsIgnoreCase("FD")))
				{
					rtnFlag = UpdateDeliveryConfirmation.updateDelivered(phoneOrder);
					DeliveredLogUtil.info("======= FD --> Failed Order :: DeliveredServlet STAGING TransPhoneOrder update Status 8 (Delivery Failed) ======= " + rtnFlag);
				}
			}
			String status =null;
			Integer regIdToTest = null;
			boolean returnValueTask = false;
			AuditTrail auditTrail = new AuditTrail();
			AuditTrail auditTrailSeq = new AuditTrail();
			Integer transMsidnFetch = null;
			String accountNoCheck = null;
			if(prodRegGrpMapId != null && prodRegGrpMapId==71){
			      DeliveredLogUtil.info("=======  IOT Order ======= ");

				if(newOrderId!=null){
					transMsidnFetch = CommonUtil.getTransMsid(new Integer(newOrderId));
				status = CommonUtil.getStatusOfMegaFortrisTask(transMsidnFetch);
					
				}

            if (prodRegGrpMapId != null && prodRegGrpMapId == 71 && status.equalsIgnoreCase("Completed") ) {
			DeliveredLogUtil.info("GOing to update portal trans task and portal trans servcie attribute");
			boolean returnValue = CommonUtil
					.updateTransServiceAttributeDelivered(new Integer(newOrderId),
							 Constant.sequenceNoDelivered);
			if(returnValue)
			returnValue = CommonUtil
						.updateTransTask(new Integer(newOrderId),
								Constant.sequenceNoDelivered);
			TransMsisdn transMsisdn=new TransMsisdn();
			transMsisdn.setTransMsid(transMsidnFetch);
			UpdateDeliveryConfirmation.updateTransMsisdn(transMsisdn);
	}
      if(prodRegGrpMapId != null && prodRegGrpMapId==71 && status.equalsIgnoreCase("Completed")){
          DeliveredLogUtil.info("Going to portal trans phone order");
          if ((delivSuccess.equalsIgnoreCase("Success")) && (statusSD.equalsIgnoreCase("SD")))
          {
            phoneOrder.setDeliveryStatusId(new Integer(1));
            phoneOrder.setDeliveryRemark("Delivered from Brightstar");
          }
          if ((delivSuccess.equalsIgnoreCase("Cancel Order")) && (statusSD.equalsIgnoreCase("CC")))
          {
            phoneOrder.setDeliveryStatusId(new Integer(8));
            phoneOrder.setDeliveryRemark("Cancel Order from Brightstar");
          }
          if (statusSD.equalsIgnoreCase("FD"))
          {
            phoneOrder.setDeliveryStatusId(new Integer(8));
            phoneOrder.setDeliveryRemark("Failed Order from Brightstar");
          }
          /*phoneOrder.setDeliveyDateTime(slDate);*/
          phoneOrder.setDeliveyDateTime(dateCreated);
          
          
          if ((orderId != null) && (orderId.length() > 0) && (delivSuccess.equalsIgnoreCase("Success")) && (statusSD.equalsIgnoreCase("SD")))
          {
            rtnFlag = UpdateDeliveryConfirmation.updateDelivered(phoneOrder);
            DeliveredLogUtil.info("======= SD --> Success :: DeliveredServlet STAGING TransPhoneOrder update Status 1 (Delivered) ======= " + rtnFlag);
          }
          if ((orderId != null) && (orderId.length() > 0) && (delivSuccess.equalsIgnoreCase("Cancel Order")) && (statusSD.equalsIgnoreCase("CC")))
          {
            rtnFlag = UpdateDeliveryConfirmation.updateDelivered(phoneOrder);
            DeliveredLogUtil.info("======= CC --> Cancel Order :: DeliveredServlet STAGING TransPhoneOrder update Status 8 (Failed) ======= " + rtnFlag);
          }
          if ((orderId != null) && (orderId.length() > 0) && (statusSD.equalsIgnoreCase("FD")))
          {
            rtnFlag = UpdateDeliveryConfirmation.updateDelivered(phoneOrder);
            DeliveredLogUtil.info("======= FD --> Failed Order :: DeliveredServlet STAGING TransPhoneOrder update Status 8 (Delivery Failed) ======= " + rtnFlag);
          }  
      }




				// Mdrive(OBD) triggering provisioning
				regIdToTest = CommonUtil.getRegId(new Integer(newOrderId));

				
			}

	
			if (rtnFlag)
			{
				auditTrailSeq = UpdateDeliveryConfirmation.getAuditSeqNo_Delivered();

				DeliveredLogUtil.info("======= DeliveredServlet STAGING auditSeqNo ======= " + auditTrailSeq.getAuditSeqNo());

				auditTrail.setAuditId(auditTrailSeq.getAuditSeqNo());

				TransPhoneOrderReg transPhoneOrderReg = UpdateDeliveryConfirmation.getTransPhoneOrderRegObj(newOrderId);

				DeliveredLogUtil.info("======= DeliveredServlet STAGING Reg Id  ======= " + transPhoneOrderReg.getRegId());
				DeliveredLogUtil.info("======= DeliveredServlet STAGING Order No  ======= " + transPhoneOrderReg.getOrderNo());

				auditTrail.setRegId(transPhoneOrderReg.getRegId());
				auditTrail.setAccessBy("MIMS");
				auditTrail.setActivity("Order has been delivered by Brightstar Order No " + transPhoneOrderReg.getOrderNo());
				auditTrail.setRemarks("Order has been delivered by Brightstar Order No " + transPhoneOrderReg.getOrderNo());
				/*auditTrail.setAuditDate(slDate);*/
				auditTrail.setAuditDate(dateCreated);
				auditTrail.setOrderNo(new Integer(newOrderId));

				boolean rtnFlagAudit = UpdateDeliveryConfirmation.insertIntoAuditTrail_Delivered(auditTrail);
				DeliveredLogUtil.info("======= InsertIntoAuditTrail STAGING rtnFlagAudit status ======= " + rtnFlagAudit);
			}
			else if ((statusSD.equalsIgnoreCase("1A")) || (statusSD.equalsIgnoreCase("2A")) || (statusSD.equalsIgnoreCase("3A")) || (statusSD.equalsIgnoreCase("4A")) || (statusSD.equalsIgnoreCase("5A")) || (statusSD.equalsIgnoreCase("6A")))
			{
				auditTrailSeq = UpdateDeliveryConfirmation.getAuditSeqNo_Delivered();

				DeliveredLogUtil.info("======= DeliveredServlet Delivery Attempts (1A - 6A) ======= " + statusSD);

				DeliveredLogUtil.info("======= DeliveredServlet Delivery Attempts (1A - 6A) auditSeqNo ======= " + auditTrailSeq.getAuditSeqNo());

				auditTrail.setAuditId(auditTrailSeq.getAuditSeqNo());

				TransPhoneOrderReg transPhoneOrderReg = UpdateDeliveryConfirmation.getTransPhoneOrderRegObj(newOrderId);

				DeliveredLogUtil.info("======= DeliveredServlet Delivery Attempts (1A - 6A) Reg Id  ======= " + transPhoneOrderReg.getRegId());
				DeliveredLogUtil.info("======= DeliveredServlet Delivery Attempts (1A - 6A) Order No  ======= " + transPhoneOrderReg.getOrderNo());

				auditTrail.setRegId(transPhoneOrderReg.getRegId());
				auditTrail.setAccessBy("MIMS");
				auditTrail.setActivity("Delivery Attempts " + statusSD + " (Order No) " + transPhoneOrderReg.getOrderNo());
				auditTrail.setRemarks("Delivery Attempts " + statusSD + " (Order No) " + transPhoneOrderReg.getOrderNo());
				/*auditTrail.setAuditDate(slDate);*/
				auditTrail.setAuditDate(dateCreated);
				auditTrail.setOrderNo(new Integer(newOrderId));

				boolean rtnFlagAudit = UpdateDeliveryConfirmation.insertIntoAuditTrail_Delivered(auditTrail);
				DeliveredLogUtil.info("======= InsertIntoAuditTrail Delivery Attempts (1A - 6A) rtnFlagAudit status ======= " + rtnFlagAudit);
			}
			String responseStr = "1|OK";
			if ((orderId != null) && (orderId.length() > 0))
			{
				response.setStatus(200);
				OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());

				writer.write(responseStr);
				writer.flush();
				writer.close();
				DeliveredLogUtil.info("=======  DeliveredServlet STAGING end ======= ");
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
					DeliveredLogUtil.info("=======  DeliveredServlet STAGING error ======= ");
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		doGet(request, response);
			}
}
