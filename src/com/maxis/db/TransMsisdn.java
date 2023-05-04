package com.maxis.db;

import java.io.Serializable;
import java.util.Date;

public class TransMsisdn
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer regId;
  private Integer transMsid;
  private String mobileNo;
  private String prefMsisdn;
  private Integer rateplanId;
  private Date dateCreated;
  private String createdBy;
  private String modifiedBy;
  private Date dateModified;
  private String companyName;
  private String regType;
  private String simNo;
  private String donorName;
  private String donorAccNo;
  private String parentId;
  private Integer promotionId;
  private Integer marketId;
  private Integer collectionId;
  private String hierarchyId;
  private String accountNo;
  private String billableIndicator;
  private String onsiteFullfillment;
  private String ratePlan;
  private String marketName;
  private String collectionName;
  private Integer msidSubsidy;
  private String promotionName;
  private String COName;
  private String errMsg;
  private String wsStatus;
  private String portInErrMsg;
  private String portInStatus;
  private String olNoAcno;
  private String msisdnStr;
  private Integer emfConfigId;
  private String billAddr1;
  private String billAddr2;
  private String billAddr3;
  private String billState;
  private String billPostcode;
  private String billCountry;
  private String simAddr1;
  private String simAddr2;
  private String simAddr3;
  private String simState;
  private String simPostcode;
  private String simCountry;
  private String onSiteStatus;
  private String mycard;
  private String maxisRfApprover;
  private Date maxisRfApproverDate;
  private String maxisRfStatus;
  private String maxisRfRemark;
  private String replenishBy;
  private Date replenishDate;
  private String mainsupp;
  private String externalId;
  private String notificationFlag;

  public String getNotificationFlag() {
	return notificationFlag;
}

public void setNotificationFlag(String notificationFlag) {
	this.notificationFlag = notificationFlag;
}

public String getExternalId() {
	return externalId;
}

public void setExternalId(String externalId) {
	this.externalId = externalId;
}

public String getSimAddr1()
  {
    return this.simAddr1;
  }

  public void setSimAddr1(String simAddr1)
  {
    this.simAddr1 = simAddr1;
  }

  public String getSimAddr2()
  {
    return this.simAddr2;
  }

  public void setSimAddr2(String simAddr2)
  {
    this.simAddr2 = simAddr2;
  }

  public String getSimAddr3()
  {
    return this.simAddr3;
  }

  public void setSimAddr3(String simAddr3)
  {
    this.simAddr3 = simAddr3;
  }

  public String getSimCountry()
  {
    return this.simCountry;
  }

  public void setSimCountry(String simCountry)
  {
    this.simCountry = simCountry;
  }

  public String getSimPostcode()
  {
    return this.simPostcode;
  }

  public void setSimPostcode(String simPostcode)
  {
    this.simPostcode = simPostcode;
  }

  public String getSimState()
  {
    return this.simState;
  }

  public void setSimState(String simState)
  {
    this.simState = simState;
  }

  public String getBillAddr1()
  {
    return this.billAddr1;
  }

  public void setBillAddr1(String billAddr1)
  {
    this.billAddr1 = billAddr1;
  }

  public String getBillAddr2()
  {
    return this.billAddr2;
  }

  public void setBillAddr2(String billAddr2)
  {
    this.billAddr2 = billAddr2;
  }

  public String getBillAddr3()
  {
    return this.billAddr3;
  }

  public void setBillAddr3(String billAddr3)
  {
    this.billAddr3 = billAddr3;
  }

  public String getBillCountry()
  {
    return this.billCountry;
  }

  public void setBillCountry(String billCountry)
  {
    this.billCountry = billCountry;
  }

  public String getBillPostcode()
  {
    return this.billPostcode;
  }

  public void setBillPostcode(String billPostcode)
  {
    this.billPostcode = billPostcode;
  }

  public String getBillState()
  {
    return this.billState;
  }

  public void setBillState(String billState)
  {
    this.billState = billState;
  }

  public Integer getEmfConfigId()
  {
    return this.emfConfigId;
  }

  public void setEmfConfigId(Integer emfConfigId)
  {
    this.emfConfigId = emfConfigId;
  }

  public String getMsisdnStr()
  {
    return this.msisdnStr;
  }

  public void setMsisdnStr(String msisdnStr)
  {
    this.msisdnStr = msisdnStr;
  }

  public String getPromotionName()
  {
    return this.promotionName;
  }

  public void setPromotionName(String promotionName)
  {
    this.promotionName = promotionName;
  }

  public String getErrMsg()
  {
    return this.errMsg;
  }

  public void setErrMsg(String errMsg)
  {
    this.errMsg = errMsg;
  }

  public String getCOName()
  {
    return this.COName;
  }

  public void setCOName(String COName)
  {
    this.COName = COName;
  }

  public String getCreatedBy()
  {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy)
  {
    this.createdBy = createdBy;
  }

  public Date getDateCreated()
  {
    return this.dateCreated;
  }

  public void setDateCreated(Date dateCreated)
  {
    this.dateCreated = dateCreated;
  }

  public Date getDateModified()
  {
    return this.dateModified;
  }

  public void setDateModified(Date dateModified)
  {
    this.dateModified = dateModified;
  }

  public String getModifiedBy()
  {
    return this.modifiedBy;
  }

  public void setModifiedBy(String modifiedBy)
  {
    this.modifiedBy = modifiedBy;
  }

  public Integer getRateplanId()
  {
    return this.rateplanId;
  }

  public void setRateplanId(Integer rateplanId)
  {
    this.rateplanId = rateplanId;
  }

  public Integer getRegId()
  {
    return this.regId;
  }

  public void setRegId(Integer regId)
  {
    this.regId = regId;
  }

  public Integer getTransMsid()
  {
    return this.transMsid;
  }

  public void setTransMsid(Integer transMsid)
  {
    this.transMsid = transMsid;
  }

  public String getMobileNo()
  {
    return this.mobileNo;
  }

  public void setMobileNo(String mobileNo)
  {
    this.mobileNo = mobileNo;
  }

  public String getPrefMsisdn()
  {
    return this.prefMsisdn;
  }

  public void setPrefMsisdn(String prefMsisdn)
  {
    this.prefMsisdn = prefMsisdn;
  }

  public String getCompanyName()
  {
    return this.companyName;
  }

  public void setCompanyName(String companyName)
  {
    this.companyName = companyName;
  }

  public String getDonorAccNo()
  {
    return this.donorAccNo;
  }

  public void setDonorAccNo(String donorAccNo)
  {
    this.donorAccNo = donorAccNo;
  }

  public String getDonorName()
  {
    return this.donorName;
  }

  public void setDonorName(String donorName)
  {
    this.donorName = donorName;
  }

  public String getRegType()
  {
    return this.regType;
  }

  public void setRegType(String regType)
  {
    this.regType = regType;
  }

  public String getSimNo()
  {
    return this.simNo;
  }

  public void setSimNo(String simNo)
  {
    this.simNo = simNo;
  }

  public String getAccountNo()
  {
    return this.accountNo;
  }

  public void setAccountNo(String accountNo)
  {
    this.accountNo = accountNo;
  }

  public String getBillableIndicator()
  {
    return this.billableIndicator;
  }

  public void setBillableIndicator(String billableIndicator)
  {
    this.billableIndicator = billableIndicator;
  }

  public Integer getCollectionId()
  {
    return this.collectionId;
  }

  public void setCollectionId(Integer collectionId)
  {
    this.collectionId = collectionId;
  }

  public String getHierarchyId()
  {
    return this.hierarchyId;
  }

  public void setHierarchyId(String hierarchyId)
  {
    this.hierarchyId = hierarchyId;
  }

  public Integer getMarketId()
  {
    return this.marketId;
  }

  public void setMarketId(Integer marketId)
  {
    this.marketId = marketId;
  }

  public Integer getPromotionId()
  {
    return this.promotionId;
  }

  public void setPromotionId(Integer promotionId)
  {
    this.promotionId = promotionId;
  }

  public String getParentId()
  {
    return this.parentId;
  }

  public void setParentId(String parentId)
  {
    this.parentId = parentId;
  }

  public String getRatePlan()
  {
    return this.ratePlan;
  }

  public void setRatePlan(String ratePlan)
  {
    this.ratePlan = ratePlan;
  }

  public String getMarketName()
  {
    return this.marketName;
  }

  public void setMarketName(String marketName)
  {
    this.marketName = marketName;
  }

  public String getCollectionName()
  {
    return this.collectionName;
  }

  public void setCollectionName(String collectionName)
  {
    this.collectionName = collectionName;
  }

  public String getOlNoAcno()
  {
    return this.olNoAcno;
  }

  public void setOlNoAcno(String olNoAcno)
  {
    this.olNoAcno = olNoAcno;
  }

  public String getPortInErrMsg()
  {
    return this.portInErrMsg;
  }

  public void setPortInErrMsg(String portInErrMsg)
  {
    this.portInErrMsg = portInErrMsg;
  }

  public String getPortInStatus()
  {
    return this.portInStatus;
  }

  public void setPortInStatus(String portInStatus)
  {
    this.portInStatus = portInStatus;
  }

  public String getWsStatus()
  {
    return this.wsStatus;
  }

  public void setWsStatus(String wsStatus)
  {
    this.wsStatus = wsStatus;
  }

  public String getOnSiteStatus()
  {
    return this.onSiteStatus;
  }

  public void setOnSiteStatus(String onSiteStatus)
  {
    this.onSiteStatus = onSiteStatus;
  }

  public Integer getMsidSubsidy()
  {
    return this.msidSubsidy;
  }

  public void setMsidSubsidy(Integer msidSubsidy)
  {
    this.msidSubsidy = msidSubsidy;
  }

  public String getMycard()
  {
    return this.mycard;
  }

  public void setMycard(String mycard)
  {
    this.mycard = mycard;
  }

  public String getMaxisRfApprover()
  {
    return this.maxisRfApprover;
  }

  public void setMaxisRfApprover(String maxisRfApprover)
  {
    this.maxisRfApprover = maxisRfApprover;
  }

  public Date getMaxisRfApproverDate()
  {
    return this.maxisRfApproverDate;
  }

  public void setMaxisRfApproverDate(Date maxisRfApproverDate)
  {
    this.maxisRfApproverDate = maxisRfApproverDate;
  }

  public String getMaxisRfRemark()
  {
    return this.maxisRfRemark;
  }

  public void setMaxisRfRemark(String maxisRfRemark)
  {
    this.maxisRfRemark = maxisRfRemark;
  }

  public String getMaxisRfStatus()
  {
    return this.maxisRfStatus;
  }

  public void setMaxisRfStatus(String maxisRfStatus)
  {
    this.maxisRfStatus = maxisRfStatus;
  }

  public String getOnsiteFullfillment()
  {
    return this.onsiteFullfillment;
  }

  public void setOnsiteFullfillment(String onsiteFullfillment)
  {
    this.onsiteFullfillment = onsiteFullfillment;
  }

  public String getMainsupp()
  {
    return this.mainsupp;
  }

  public void setMainsupp(String mainsupp)
  {
    this.mainsupp = mainsupp;
  }

  public String getReplenishBy()
  {
    return this.replenishBy;
  }

  public void setReplenishBy(String replenishBy)
  {
    this.replenishBy = replenishBy;
  }

  public Date getReplenishDate()
  {
    return this.replenishDate;
  }

  public void setReplenishDate(Date replenishDate)
  {
    this.replenishDate = replenishDate;
  }
}
