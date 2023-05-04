package com.maxis.order;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.maxis.config.BrightstarRoadShowConfig;
import com.maxis.constant.Constant;
import com.maxis.db.MaxisEbdPortal;
import com.maxis.log.RoadShowLogUtil;
import java.sql.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RoadShowUpdateMims
{
  protected Log log = LogFactory.getLog(RoadShowUpdateMims.class);
  private SqlMapClient roadshowConfirmMapClient_ = null;

  public boolean update_PORTAL_TRANS_PHONE_ORDER_S(Integer regId, String status, Integer orderNo)
  {
    boolean resFlag = false;
    try
    {
      Date dateCreated = new Date(System.currentTimeMillis());

      this.roadshowConfirmMapClient_ = BrightstarRoadShowConfig.getSqlMapInstance();
      if (regId != null)
      {
        MaxisEbdPortal maxisData = new MaxisEbdPortal();
        maxisData.setOrderNo(orderNo);

        RoadShowLogUtil.info("===> dateCreated ===> " + dateCreated);
        RoadShowLogUtil.info("===> orderNo ===> " + orderNo);
        if (status.equalsIgnoreCase("S"))
        {
          this.roadshowConfirmMapClient_.update(Constant.update_RoadshowMimsSuccess, maxisData);
          RoadShowLogUtil.info("===> SQL :: update PORTAL_TRANS_PHONE_ORDER set MIMS_STATUS = 'S', MIMS_SUBMIT_DATE = sysdate, DELIVERY_STATUS_ID = 2, DELIVERY_DATETIME = sysdate where ORDER_NO =" + orderNo);
          resFlag = true;
        }
        else
        {
          RoadShowLogUtil.info("===> No Updation but status is failed ====> ");
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

      this.roadshowConfirmMapClient_ = BrightstarRoadShowConfig.getSqlMapInstance();
      if (regId != null)
      {
        MaxisEbdPortal maxisData = new MaxisEbdPortal();
        maxisData.setOrderNo(orderNo);

        RoadShowLogUtil.info("===> dateCreated ===> " + dateCreated);
        RoadShowLogUtil.info("===> orderNo ===> " + orderNo);
        if (status.equalsIgnoreCase("M"))
        {
          this.roadshowConfirmMapClient_.update(Constant.update_RoadshowMimsSuccess_N, maxisData);
          RoadShowLogUtil.info("===> SQL :: update PORTAL_TRANS_PHONE_ORDER set MIMS_STATUS = 'N', MIMS_SUBMIT_DATE = sysdate, DELIVERY_STATUS_ID = 2, DELIVERY_DATETIME = sysdate where ORDER_NO =" + orderNo);
          resFlag = true;
        }
        else if (status.equalsIgnoreCase("H"))
        {
          this.roadshowConfirmMapClient_.update(Constant.update_RoadshowMimsSuccess_H, maxisData);
          RoadShowLogUtil.info("===> SQL :: update PORTAL_TRANS_PHONE_ORDER set MIMS_STATUS = 'H', MIMS_SUBMIT_DATE = sysdate, DELIVERY_STATUS_ID = 2, DELIVERY_DATETIME = sysdate where ORDER_NO =" + orderNo);
          resFlag = true;
        }
        else
        {
          RoadShowLogUtil.info("===> No Updation but status is failed ====> ");
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
