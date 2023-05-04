package com.maxis.order;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.maxis.config.BrightstarSqlConfig;
import com.maxis.config.ContractExtSqlConfig;
import com.maxis.constant.Constant;
import com.maxis.db.MaxisEbdPortal;
import com.maxis.log.ContractExtLog;
import java.sql.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BrightStarMims
{
  protected Log log = LogFactory.getLog(BrightStarMims.class);
  private SqlMapClient contractMapClient = null;
  private SqlMapClient brightStarMapClient = null;
 
  public boolean update_PORTAL_TRANS_PHONE_ORDER_S(Integer regId, String status, Integer orderNo,String deviceOrderNo)
  {
    boolean resFlag = false;
    try
    {
      Date dateCreated = new Date(System.currentTimeMillis());

      this.brightStarMapClient = BrightstarSqlConfig.getSqlMapInstance();
      if (regId != null)
      {
        MaxisEbdPortal maxisData = new MaxisEbdPortal();
        maxisData.setOrderNo(orderNo);
        maxisData.setDeviceOrderNo(deviceOrderNo);
        this.log.info("===> dateCreated ===> " + dateCreated);
        this.log.info("===> orderNo ===> " + orderNo);
        if (status.equalsIgnoreCase("S"))
        {
          this.brightStarMapClient.update(Constant.UPDATE_EBDPORTAL_MIMS_SUCCESS, maxisData);
          this.log.info("===> SQL :: update PORTAL_TRANS_PHONE_ORDER set MIMS_STATUS = 'S', MIMS_SUBMIT_DATE = sysdate, DEVICE_ORDER_NO="+deviceOrderNo+", DELIVERY_STATUS_ID = 2, DELIVERY_DATETIME = sysdate where ORDER_NO =" + orderNo);
          resFlag = true;
        }
        else
        {
          this.log.info("===> No Updation but status is failed ====> ");
          resFlag = false;
        }
      }
    }
    catch (Exception ex)
    {
      ex.getMessage();
      resFlag = false;
    }
    return resFlag;
  }

  public boolean update_PORTAL_TRANS_PHONE_ORDER_M(Integer regId, String status, Integer orderNo)
  {
    boolean resFlag = false;
    try
    {
      Date dateCreated = new Date(System.currentTimeMillis());

      this.brightStarMapClient = BrightstarSqlConfig.getSqlMapInstance();
      if (regId != null)
      {
        MaxisEbdPortal maxisData = new MaxisEbdPortal();
        maxisData.setOrderNo(orderNo);

        this.log.info("===> dateCreated ===> " + dateCreated);
        this.log.info("===> orderNo ===> " + orderNo);
        if (status.equalsIgnoreCase("M"))
        {
          this.brightStarMapClient.update(Constant.UPDATE_EBDPORTAL_MIMS_SUCCESS_M, maxisData);
          this.log.info("===> SQL :: update PORTAL_TRANS_PHONE_ORDER set MIMS_STATUS = 'M', MIMS_SUBMIT_DATE = sysdate, DELIVERY_STATUS_ID = 2, DELIVERY_DATETIME = sysdate where ORDER_NO =" + orderNo);
          resFlag = true;
        }
        else
        {
          this.log.info("===> No Updation but status is failed ====> ");
          resFlag = false;
        }
      }
    }
    catch (Exception ex)
    {
      ex.getMessage();
      resFlag = false;
    }
    return resFlag;
  }

  public boolean updateContractExtPortalTransMsisdn(Integer regId, String status, Integer transMsid)
  {
    boolean resFlag = false;
    try
    {
      Date dateCreated = new Date(System.currentTimeMillis());
      this.contractMapClient = ContractExtSqlConfig.getSqlMapInstance();
      if (regId != null)
      {
        MaxisEbdPortal maxisData = new MaxisEbdPortal();
        maxisData.setRegId(regId);
        maxisData.setTransMsid(transMsid);

        ContractExtLog.info("===> regId ===> " + regId);
        ContractExtLog.info("===> transMsid ===> " + transMsid);
        ContractExtLog.info("===> dateCreated ===> " + dateCreated);
        if (status.equalsIgnoreCase("S"))
        {
          this.contractMapClient.update(Constant.UPDATE_CONTRACT_EXT_S, maxisData);
          ContractExtLog.info("===> Contract Ext Updated successfully ====> ");
          resFlag = true;
        }
        else
        {
          ContractExtLog.info("===> No Updation but status is failed ====> ");
          resFlag = false;
        }
      }
    }
    catch (Exception ex)
    {
      ex.getMessage();
      resFlag = false;
    }
    return resFlag;
  }
}
