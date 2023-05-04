package com.maxis.db;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.maxis.config.BrightstarRoadShowConfig;
import java.io.PrintStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBConnectionSQL
{
  private SqlMapClient fuelMapClient = null;
  protected static Log log = LogFactory.getLog(DBConnectionSQL.class);

  public void setDB()
  {
    try
    {
      this.fuelMapClient = BrightstarRoadShowConfig.getSqlMapInstance();
    }
    catch (Exception ex)
    {
      log.info("Error in setup " + ex.getMessage());
    }
  }

  public AuditTrail getAuditSequence()
  {
    AuditTrail auditTrail = null;
    try
    {
      auditTrail = (AuditTrail)this.fuelMapClient.queryForObject("select_audit_sequence");
    }
    catch (Exception ex)
    {
      log.error("Exception " + ex.getMessage());
    }
    return auditTrail;
  }

  public void insertToAuditTrail(AuditTrail auditTrail)
  {
    try
    {
      this.fuelMapClient.insert("insertAuditTrail", auditTrail);
    }
    catch (Exception e)
    {
      System.out.println("Inside the insert exception of the insertToAuditTrail...." + e.getMessage());
    }
  }

  public RoadShow getRoadShowDetails(RoadShow roadShow)
  {
    try
    {
      roadShow = (RoadShow)this.fuelMapClient.queryForObject("getRoadShowValues", roadShow);
    }
    catch (Exception e)
    {
      System.out.println("Inside the getEmfConfig....." + e.getMessage());
    }
    return roadShow;
  }

  public CustomerInfo getCustIdSequence()
  {
    CustomerInfo customerInfo = null;
    try
    {
      customerInfo = (CustomerInfo)this.fuelMapClient.queryForObject("select_cust_sequence");
    }
    catch (Exception ex)
    {
      log.error("Exception " + ex.getMessage());
    }
    return customerInfo;
  }

  public void insertCustInfo(CustomerInfo customerInfo)
  {
    try
    {
      this.fuelMapClient.insert("insertCustInfo", customerInfo);
    }
    catch (Exception e)
    {
      System.out.println("Inside the insert exception of the cust info page....." + e.getMessage());
    }
  }

  public PortalRegistrationMaster getRegMasterSequence()
  {
    PortalRegistrationMaster portalRegistrationMaster = null;
    try
    {
      portalRegistrationMaster = (PortalRegistrationMaster)this.fuelMapClient.queryForObject("select_regMaster_sequence");
    }
    catch (Exception ex)
    {
      log.error("Exception " + ex.getMessage());
    }
    return portalRegistrationMaster;
  }

  public TransMsisdn getTransMsisdnSequence()
  {
    TransMsisdn transMsisdn = null;
    try
    {
      transMsisdn = (TransMsisdn)this.fuelMapClient.queryForObject("select_transMsid_sequence");
    }
    catch (Exception ex)
    {
      log.error("Exception " + ex.getMessage());
    }
    return transMsisdn;
  }

  public void insertRegMaster(PortalRegistrationMaster regMaster)
  {
    try
    {
      this.fuelMapClient.insert("insertRegMaster", regMaster);
    }
    catch (Exception e)
    {
      System.out.println("Inside the insert exception of the insertRegMaster...." + e.getMessage());
    }
  }

  public void insertTransMsisdn(TransMsisdn transMsisdn)
  {
    try
    {
      this.fuelMapClient.insert("insertTransMsisdn", transMsisdn);
    }
    catch (Exception e)
    {
      System.out.println("Inside the insert exception of the insertTransMsisdn....." + e.getMessage());
    }
  }

  public Device getDeviceDetails(Device device)
  {
    try
    {
      device = (Device)this.fuelMapClient.queryForObject("getDeviceDetails", device);
    }
    catch (Exception e)
    {
      System.out.println("Inside the getEmfConfig....." + e.getMessage());
    }
    return device;
  }

  public PhoneOrder getPhoneOrderSequence()
  {
    PhoneOrder phoneOrder = null;
    try
    {
      phoneOrder = (PhoneOrder)this.fuelMapClient.queryForObject("select_phone_order_sequence");
    }
    catch (Exception ex)
    {
      log.error("Exception " + ex.getMessage());
    }
    return phoneOrder;
  }

  public void insertPhoneOrder(PhoneOrder po)
  {
    try
    {
      this.fuelMapClient.insert("insertPhoneOrder", po);
    }
    catch (Exception e)
    {
      System.out.println("Inside the insert exception of the insertPhoneOrder...." + e.getMessage());
    }
  }

  public void insertPhoneOrderReg(PhoneOrder po)
  {
    try
    {
      this.fuelMapClient.insert("insertPhoneOrderReg", po);
    }
    catch (Exception e)
    {
      System.out.println("Inside the insert exception of the insertPhoneOrderReg...." + e.getMessage());
    }
  }
}
