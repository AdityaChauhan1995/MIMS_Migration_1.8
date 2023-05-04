package com.maxis.order;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.maxis.config.ThreeGplSqlConfig;
import com.maxis.constant.Constant;
import com.maxis.db.PhoneOrder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UpdateSalesConfirmation
{
  private static SqlMapClient portalMapClient = null;
  static boolean resFlag = false;
  protected static Log log = LogFactory.getLog(UpdateSalesConfirmation.class);

  public static boolean updateSalesConfirmation(PhoneOrder phoneOrder)
  {
    try
    {
      portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

      portalMapClient.update(Constant.UPDATE_SALES_CONFIRMATION, phoneOrder);
      log.info("Updated UpdateSalesConfirmation SUCCESS for order no = " + phoneOrder.getOrderNo() + " return true ");
      resFlag = true;
    }
    catch (Exception ex)
    {
      log.info("Updated UpdateSalesConfirmation FAILED for order no = " + phoneOrder.getOrderNo());
      resFlag = false;
    }
    return resFlag;
  }
}