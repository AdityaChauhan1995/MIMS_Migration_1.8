package com.maxis.order;

import java.sql.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.maxis.config.ThreeGplSqlConfig;
import com.maxis.constant.Constant;
import com.maxis.db.AuditTrail;
import com.maxis.db.MaxisEbdPortal;
import com.maxis.db.PhoneOrder;
import com.maxis.db.TransMsisdn;
import com.maxis.db.TransPhoneOrderReg;
import com.maxis.db.PortalTransWMAction;
import com.maxis.log.DeliveredLogUtil;
import com.maxis.log.DeliveryConfirmationLogUtil;
import com.maxis.log.RejectLogUtil;
import com.maxis.log.SalesConfirmationLogUtil;

public class UpdateDeliveryConfirmation
{
  private static SqlMapClient portalMapClient = null;
  static boolean resFlag = false;
  static Integer seqNo = null;
  protected static Log log = LogFactory.getLog(UpdateDeliveryConfirmation.class);

  public static boolean updateDeliveryConfirmation(PhoneOrder phoneOrder)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.update(Constant.UPDATE_DELIVERY_CONFIRMATION, phoneOrder);
      DeliveryConfirmationLogUtil.info("Update DeliveryConfirmationServlet for order no = " + phoneOrder.getOrderNo() + " return true ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      DeliveryConfirmationLogUtil.info("Update DeliveryConfirmationServlet failed for order no = " + phoneOrder.getOrderNo());
      resFlag = false;
    }
    return resFlag;
  }

  public static boolean updateTransMsisdn(TransMsisdn transMsisdn)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.update(Constant.update_TransMsisdn, transMsisdn);
      DeliveryConfirmationLogUtil.info("Update Trans Msisdn for order no = " + transMsisdn.getTransMsid() + " return true ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      DeliveryConfirmationLogUtil.info("Update Trans Msisdn failed for order no = " + transMsisdn.getTransMsid());
      resFlag = false;
    }
    return resFlag;
  }
  
  public static boolean updateDelivered(PhoneOrder phoneOrder)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.update(Constant.UPDATE_DELIVERED, phoneOrder);
      DeliveredLogUtil.info("Update DeliveredServlet for order no = " + phoneOrder.getOrderNo() + " return true ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      DeliveredLogUtil.info("Update DeliveredServlet failed for order no = " + phoneOrder.getOrderNo());
      resFlag = false;
    }
    return resFlag;
  }

  public static boolean updateSalesConfirmation(PhoneOrder phoneOrder)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.update(Constant.UPDATE_SALES_CONFIRMATION, phoneOrder);
      SalesConfirmationLogUtil.info("Update SalesConfirmationServlet for order no = " + phoneOrder.getOrderNo() + " return true ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      SalesConfirmationLogUtil.info("Update SalesConfirmationServlet failed for order no = " + phoneOrder.getOrderNo());
      resFlag = false;
    }
    return resFlag;
  }
  public static boolean insertTransWMAction(PortalTransWMAction transWMAction)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.update(Constant.INSERT_TRANSWMACTION, transWMAction);
      DeliveredLogUtil.info("Update transWmAction for order no = " + transWMAction.getOrderNo() + " return true ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      DeliveredLogUtil.info("Update transWmAction failed for order no = " + transWMAction.getOrderNo());
      resFlag = false;
    }
    return resFlag;
  }

  public static boolean updateRejectConfirmation(PhoneOrder phoneOrder)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.update(Constant.UPDATE_DELIVERY_CONFIRMATION, phoneOrder);
      RejectLogUtil.info("Update RejectServlet for order no = " + phoneOrder.getOrderNo() + " return true ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      RejectLogUtil.info("Update RejectServlet failed for order no = " + phoneOrder.getOrderNo());
      resFlag = false;
    }
    return resFlag;
  }

  public static AuditTrail getAuditSeqNo_DeliveryConfirmation()
  {
    AuditTrail auditTrail = new AuditTrail();
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      auditTrail = (AuditTrail)portalMapClient.queryForObject(Constant.select_AUDIT_SEQ_NO);
      DeliveryConfirmationLogUtil.info("======== DeliveryConfirmationServlet Audit Seq No  ======== " + auditTrail.getAuditSeqNo());
    }
    catch (Exception ex)
    {
      DeliveryConfirmationLogUtil.info("======== DeliveryConfirmationServlet getAuditSeqNo AM IN EXCEPTION ======== " + ex.getMessage());
    }
    return auditTrail;
  }

  public static AuditTrail getAuditSeqNo_Delivered()
  {
    AuditTrail auditTrail = new AuditTrail();
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      auditTrail = (AuditTrail)portalMapClient.queryForObject(Constant.select_AUDIT_SEQ_NO);
      DeliveredLogUtil.info("======== DeliveredServlet Audit Seq No  ======== " + auditTrail.getAuditSeqNo());
    }
    catch (Exception ex)
    {
      DeliveredLogUtil.info("======== DeliveredServlet getAuditSeqNo AM IN EXCEPTION ======== " + ex.getMessage());
    }
    return auditTrail;
  }

  public static AuditTrail getAuditSeqNo_Sales()
  {
    AuditTrail auditTrail = new AuditTrail();
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      auditTrail = (AuditTrail)portalMapClient.queryForObject(Constant.select_AUDIT_SEQ_NO);
      SalesConfirmationLogUtil.info("======= SalesConfirmationServlet Audit Seq No ======= " + auditTrail.getAuditSeqNo());
    }
    catch (Exception ex)
    {
      SalesConfirmationLogUtil.info("======= SalesConfirmationServlet getAuditSeqNo AM IN EXCEPTION ====== " + ex.getMessage());
    }
    return auditTrail;
  }

  public static TransPhoneOrderReg getTransPhoneOrderRegObj(String orderNo)
  {
    TransPhoneOrderReg obj = new TransPhoneOrderReg();
    TransPhoneOrderReg objSet = new TransPhoneOrderReg();
    try
    {
      objSet.setOrderNo(new Integer(orderNo));

      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      obj = (TransPhoneOrderReg)portalMapClient.queryForObject(Constant.select_PORTAL_TRANS_PHONE_ORDER_REG, objSet);
    }
    catch (Exception ex)
    {
      DeliveryConfirmationLogUtil.info("UpdateDeliveryConfirmation getTransPhoneOrderRegObj AM IN EXCEPTION" + ex.getMessage());
    }
    return obj;
  }

  public static boolean insertIntoAuditTrail_DeliveryConfirmation(AuditTrail auditTrail)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.insert(Constant.insert_AuditTrail, auditTrail);
      DeliveryConfirmationLogUtil.info("======== DeliveryConfirmationServlet Insert in Audit Trail Successfull ! ======= ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      DeliveryConfirmationLogUtil.info("Am in UpdateDeliveryConfirmation Insert in Audit Trail Failed ! :: Exception");
      resFlag = false;
    }
    return resFlag;
  }

  public static boolean insertIntoAuditTrail_Delivered(AuditTrail auditTrail)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.insert(Constant.insert_AuditTrail, auditTrail);
      DeliveredLogUtil.info("======== DeliveredServlet Insert in Audit Trail Successfull ! ======= ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      DeliveredLogUtil.info("Am in DeliveredServlet Insert in Audit Trail Failed ! :: Exception");
      resFlag = false;
    }
    return resFlag;
  }

  public static boolean insertIntoAuditTrail_Sales(AuditTrail auditTrail)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.insert(Constant.insert_AuditTrail, auditTrail);
      SalesConfirmationLogUtil.info("======== SalesConfirmationServlet Insert in Audit Trail Successfull ! ======= ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      SalesConfirmationLogUtil.info("Am in SalesConfirmationServlet Insert in Audit Trail Failed ! :: Exception");
      resFlag = false;
    }
    return resFlag;
  }

  public static boolean insertIntoPortalRegistrationStatus(Integer regId, String status, String remarks) {
	  DeliveryConfirmationLogUtil.info("UpdateDeliveryConfirmation insertIntoPortalRegistrationStatus Start = " + regId +status +remarks);
		boolean resFlag = false;
		try
		{
			Date dateCreated = new Date(System.currentTimeMillis());

			portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();
			if (regId != null) {
				MaxisEbdPortal maxisData = new MaxisEbdPortal();
				maxisData.setRegId(regId);
				maxisData.setStatus(status);
				maxisData.setRemarks(remarks);

				log.info("===> dateCreated ===> " + dateCreated);
				log.info("===> regId ===> " + regId);

				portalMapClient.insert(Constant.INSERT_MPOS_REG_STATUS_TABLE_ON_DELIVERY, maxisData);
				log.info("===> SQL :: insert into PORTAL_REGISTRATION_STATUS (reg_status_id, reg_id, reg_status, remarks, created_user, date_created) values (portal_reg_status_seq_no.nextval, regId, 'PSDL', 'Order picked up by MIMS', 'MIMS', sysdate" + regId);
				resFlag = true;
			}
		} catch (Exception ex) {
			ex.getMessage();
			resFlag = false;
		}
		return resFlag;
	}


	public static boolean updatePortalCompanySubscTxns(Integer regId, String status, String remarks) {
		DeliveryConfirmationLogUtil.info("UpdateDeliveryConfirmation updatePortalCompanySubscTxns Start = " + regId +status +remarks);
		boolean resFlag = false;
		try
		{
			Date dateCreated = new Date(System.currentTimeMillis());

			portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();
			if (regId != null) {
				MaxisEbdPortal maxisData = new MaxisEbdPortal();
				maxisData.setRegId(regId);
				maxisData.setStatus(status);
				maxisData.setRemarks(remarks);

				log.info("===> dateCreated ===> " + dateCreated);
				log.info("===> regId ===> " + regId);
				log.info("===> status ===> " + status);
				log.info("===> remarks ===> " + remarks);

				portalMapClient.update(Constant.UPDATE_MPOS_TRAN_TABLE_ON_DELIVERY, maxisData);
				log.info("===> SQL :: update PORTAL_COMPANY_SUBSC_TXNS set STATUS = " +status +"where REG_ID = " +regId);
				resFlag = true;
			}
		} catch (Exception ex) {
			ex.getMessage();
			resFlag = false;
		}

		return resFlag;
	}

	 public static TransPhoneOrderReg getTransCompanySubscTxnsObj(String orderNo) {
		 DeliveryConfirmationLogUtil.info("UpdateDeliveryConfirmation getTransCompanySubscTxnsObj Start = " + orderNo);
		    TransPhoneOrderReg obj = new TransPhoneOrderReg();
		    TransPhoneOrderReg objSet = new TransPhoneOrderReg();
		    try {
		      objSet.setOrderNo(new Integer(orderNo));

		      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

		      obj = (TransPhoneOrderReg)portalMapClient.queryForObject(Constant.SELECT_PORTAL_COMPANY_SUBSC_TRANS, objSet);
		    }
		    catch (Exception ex) {
		      DeliveryConfirmationLogUtil.info("UpdateDeliveryConfirmation getTransPhoneOrderRegObj AM IN EXCEPTION" + ex.getMessage());
		    }

		    return obj;
		  }
}
