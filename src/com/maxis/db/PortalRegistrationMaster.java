package com.maxis.db;

import java.io.Serializable;
import java.util.Date;

public class PortalRegistrationMaster
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer regId;
  private Integer custId;
  private String custBrnNo;
  private String regType;
  private String accountType;
  private String customerType;
  private String parentId;
  private String parentAcDetail;
  private String creditStatus;
  private String regStatus;
  private String dealerCode;
  private String salesmenCode;
  private String salesmenName;
  private String supportCenterCode;
  private Date dateCreated;
  private String verifierCode;
  private Date dateVerified;
  private String verifierRemark;
  private String routeToCode;
  private String approverCode;
  private Date creditDateApproved;
  private String approverRemark;
  private String finalJustification;
  private String donor;
  private String portingType;
  private Integer totPhoneSubsidy;
  private Integer totPhoneSubsidy1;
  private String promoCode;
  private String hireId;
  private String acctCategory;
  private String billInd;
  private String marketCode;
  private String collectCode;
  private String regApproverCode;
  private Date regDateApproved;
  private Integer resubmitInd;
  private String vasVerInd;
  private String accMgrCode;
  private Date dateAppeal;
  private String appealRemark;
  private String errMsg;
  private String orderId;
  private String accountNo;
  private String accountNo1;
  private String wsStatus;
  private String submRemark;
  private String finalRemark;
  private String approvalRefNo;
  private String portInStatus;
  private Integer existingLineNo;
  private Integer tolLineApproved;
  private String dealerName;
  private String approverUserGroup;
  private String phoneOrderStatus;
  private String closeOrderRemark;
  private Date phoneCloseDate;
  private String phoneApproverId;
  private String creditStatusCrr2;
  private String sourceInd;
  private Date latestResubmDate;
  private Integer supportingCenter;
  private String supportingCenterName;
  private String phoneMarker;
  private char phoneMarker1;
  private Integer remainingSubsidyAmount;
  private Integer rollupId;
  private String rollup;
  private Date dateCreated1;
  private String maxisRfApprover;
  private Date maxisRfApproverDate;
  private String maxisRfStatus;
  private String maxisRfStatus2;
  private String maxisRfRemark;
  private String productName;
  private String regBy;
  private CustomerInfo portalCustInfo;
  private TransMsisdn transMsisdn;
  private String customerName;
  private Integer regId1;
  private Integer custId1;
  private String custBrnNo1;
  private String dealerName1;
  private Date regDateApproved1;
  private Date regDateApprovedTo;
  private String delAddr1;
  private String delAddr2;
  private String delAddr3;
  private String delPostcode;
  private String delState;
  private String delCountry;
  private String address;
  private Integer deviceId;
  private String phoneModel;
  private Integer orderNo;
  private Integer phoneTopupAmount;
  private String vendorCode;
  private Integer deliveryStatusId;
  private Integer deliveryStatusId1;
  private String deliveryRemark;
  private Date deliveyDateTime;
  private Integer phoneSubsidyAmount;
  private Integer phoneUnitPrice;
  private String verifiedBy;
  private Integer sno;
  private String uploadDocInd;
  private String fileNameUnload;
  private String fileSize;
  private Integer vendorId;
  private String vendorName;
  private String regStatus1;
  private String regStatus2;
  private Date fromDate;
  private Date toDate;
  private String msisdn;
  private Integer maxisCenterId;
  private String custName;
  private String rfStatus;
  private String mqStatus;
  private String remarks;
  private Date subsidyExpiryDate;
  private Date subsidyExpiryDate1;
  private String billAddr1;
  private String billAddr2;
  private String billAddr3;
  private String billPostcode;
  private String billState;
  private String billCountry;
  private String deliveryBy;
  private String deliverStatusDesc;
  private Integer closeStatusId;
  private String closeBy;
  private Date closeDate;
  private Integer deviceId1;
  private String deviceName;
  private String customerName1;
  private String companyName1;
  private String closeStatusDesc;
  private String dealerCode1;
  private int rowNo;
  private String brandName;
  private Integer brandId;
  private Integer subsidyPrice;
  private Integer topup;
  private Integer unitPrice;
  private int displaytabletotalsubsidy;
  private String typeOfReg;
  private String navigation;
  private String donorId;
  private Integer totLinesRegistred;
  private String delContactName;
  private String delContactIc;
  private String delContactPhoneNo;
  private String totalSubsidyAmt1;
  private Integer tempTotalSubsidyAmt;
  private String address1;
  private String address2;
  private String city;
  private String state;
  private String postCode;
  private Integer countryId;
  private String country_name;
  private Integer roadshowId;
  private Integer linesRegistred;
  private Integer transMsid;
  private Integer invoiceNo;
  private String mycard;
  private String closeRemark;
  private String tempUploadRegId;
  private String fileName_1;
  private String fileName_2;
  private String fileName_3;
  private String fileName_4;
  private String fileName_5;
  private String fileName_6;
  private String fileName_7;
  private String fileName_8;
  private String fileName_9;
  private String address1SiteA;
  private String address2SiteA;
  private String postCodeSiteA;
  private String stateSiteA;
  private String buildingSiteA;
  private String citySiteA;
  private String countrySiteA;
  private String address1SiteB;
  private String address2SiteB;
  private String postCodeSiteB;
  private String stateSiteB;
  private String buildingSiteB;
  private String citySiteB;
  private String countrySiteB;
  private String contactNameSiteA;
  private String contactNumberSiteA;
  private String mobileNumberSiteA;
  private String faxNoSiteA;
  private String emailSiteA;
  private String contactNameSiteB;
  private String contactNumberSiteB;
  private String mobileNumberSiteB;
  private String faxNoSiteB;
  private String emailSiteB;
  private String address3SiteB;
  private String address3SiteA;
  private String createdBy;
  private String modifiedBy;
  private String delCountryById;
  private String billCountryById;
  private Integer promotionId;
  private String deviceName1;
  private String regType1;
  private String onsiteFullfillment;
  private Integer phoneSubsidyBalance;
  private String roleName;
  private String createdByMsisdn;
  private Date dateCreatedMsisdn;
  private Date verifiedDate;
  private String createdRemarks;
  private String verifiedRemark;
  private String conditionCheckParm;
  private String companyName;
  private Integer roadshowId1;
  private String sofno;
  private String cmssno;
  private Integer prodRegGrpMapId;
	private Date dateModified; 
	private Integer prodCatId;
  private Integer prodGrpId;

  public Integer getProdGrpId() {
	return prodGrpId;
}

public void setProdGrpId(Integer prodGrpId) {
	this.prodGrpId = prodGrpId;
}

public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

public Integer getProdRegGrpMapId() {
	return prodRegGrpMapId;
}

public void setProdRegGrpMapId(Integer prodRegGrpMapId) {
	this.prodRegGrpMapId = prodRegGrpMapId;
}

public String getConditionCheckParm()
  {
    return this.conditionCheckParm;
  }

  public void setConditionCheckParm(String conditionCheckParm)
  {
    this.conditionCheckParm = conditionCheckParm;
  }

  public String getVerifiedRemark()
  {
    return this.verifiedRemark;
  }

  public void setVerifiedRemark(String verifiedRemark)
  {
    this.verifiedRemark = verifiedRemark;
  }

  public Date getVerifiedDate()
  {
    return this.verifiedDate;
  }

  public void setVerifiedDate(Date verifiedDate)
  {
    this.verifiedDate = verifiedDate;
  }

  public String getRoleName()
  {
    return this.roleName;
  }

  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }

  public String getOnsiteFullfillment()
  {
    return this.onsiteFullfillment;
  }

  public void setOnsiteFullfillment(String onsiteFullfillment)
  {
    this.onsiteFullfillment = onsiteFullfillment;
  }

  public Integer getPhoneSubsidyBalance()
  {
    return this.phoneSubsidyBalance;
  }

  public void setPhoneSubsidyBalance(Integer phoneSubsidyBalance)
  {
    this.phoneSubsidyBalance = phoneSubsidyBalance;
  }

  public String getRegType1()
  {
    return this.regType1;
  }

  public void setRegType1(String regType1)
  {
    this.regType1 = regType1;
  }

  public String getBillCountryById()
  {
    return this.billCountryById;
  }

  public void setBillCountryById(String billCountryById)
  {
    this.billCountryById = billCountryById;
  }

  public String getDelCountryById()
  {
    return this.delCountryById;
  }

  public void setDelCountryById(String delCountryById)
  {
    this.delCountryById = delCountryById;
  }

  public String getCloseRemark()
  {
    return this.closeRemark;
  }

  public void setCloseRemark(String closeRemark)
  {
    this.closeRemark = closeRemark;
  }

  public Integer getInvoiceNo()
  {
    return this.invoiceNo;
  }

  public void setInvoiceNo(Integer invoiceNo)
  {
    this.invoiceNo = invoiceNo;
  }

  public Integer getTransMsid()
  {
    return this.transMsid;
  }

  public void setTransMsid(Integer transMsid)
  {
    this.transMsid = transMsid;
  }

  public Integer getLinesRegistred()
  {
    return this.linesRegistred;
  }

  public void setLinesRegistred(Integer linesRegistred)
  {
    this.linesRegistred = linesRegistred;
  }

  public String getDonorId()
  {
    return this.donorId;
  }

  public void setDonorId(String donorId)
  {
    this.donorId = donorId;
  }

  public String getNavigation()
  {
    return this.navigation;
  }

  public void setNavigation(String navigation)
  {
    this.navigation = navigation;
  }

  public Integer getTotLinesRegistred()
  {
    return this.totLinesRegistred;
  }

  public void setTotLinesRegistred(Integer totLinesRegistred)
  {
    this.totLinesRegistred = totLinesRegistred;
  }

  public String getTotalSubsidyAmt1()
  {
    return this.totalSubsidyAmt1;
  }

  public void setTotalSubsidyAmt1(String totalSubsidyAmt1)
  {
    this.totalSubsidyAmt1 = totalSubsidyAmt1;
  }

  public String getTypeOfReg()
  {
    return this.typeOfReg;
  }

  public void setTypeOfReg(String typeOfReg)
  {
    this.typeOfReg = typeOfReg;
  }

  public Integer getBrandId()
  {
    return this.brandId;
  }

  public void setBrandId(Integer brandId)
  {
    this.brandId = brandId;
  }

  public int getDisplaytabletotalsubsidy()
  {
    return this.displaytabletotalsubsidy;
  }

  public void setDisplaytabletotalsubsidy(int displaytabletotalsubsidy)
  {
    this.displaytabletotalsubsidy = displaytabletotalsubsidy;
  }

  public Integer getSubsidyPrice()
  {
    return this.subsidyPrice;
  }

  public void setSubsidyPrice(Integer subsidyPrice)
  {
    this.subsidyPrice = subsidyPrice;
  }

  public Integer getTopup()
  {
    return this.topup;
  }

  public void setTopup(Integer topup)
  {
    this.topup = topup;
  }

  public Integer getUnitPrice()
  {
    return this.unitPrice;
  }

  public void setUnitPrice(Integer unitPrice)
  {
    this.unitPrice = unitPrice;
  }

  public String getBrandName()
  {
    return this.brandName;
  }

  public void setBrandName(String brandName)
  {
    this.brandName = brandName;
  }

  public int getRowNo()
  {
    return this.rowNo;
  }

  public void setRowNo(int rowNo)
  {
    this.rowNo = rowNo;
  }

  public String getRemarks()
  {
    return this.remarks;
  }

  public void setRemarks(String remarks)
  {
    this.remarks = remarks;
  }

  public String getVendorName()
  {
    return this.vendorName;
  }

  public void setVendorName(String vendorName)
  {
    this.vendorName = vendorName;
  }

  public String getCustName()
  {
    return this.custName;
  }

  public void setCustName(String custName)
  {
    this.custName = custName;
  }

  public Integer getMaxisCenterId()
  {
    return this.maxisCenterId;
  }

  public void setMaxisCenterId(Integer maxisCenterId)
  {
    this.maxisCenterId = maxisCenterId;
  }

  public String getRfStatus()
  {
    return this.rfStatus;
  }

  public void setRfStatus(String rfStatus)
  {
    this.rfStatus = rfStatus;
  }

  public String getDeliveryRemark()
  {
    return this.deliveryRemark;
  }

  public void setDeliveryRemark(String deliveryRemark)
  {
    this.deliveryRemark = deliveryRemark;
  }

  public String getVerifiedBy()
  {
    return this.verifiedBy;
  }

  public void setVerifiedBy(String verifiedBy)
  {
    this.verifiedBy = verifiedBy;
  }

  public Integer getCustId1()
  {
    return this.custId1;
  }

  public void setCustId1(Integer custId1)
  {
    this.custId1 = custId1;
  }

  public Integer getPhoneUnitPrice()
  {
    return this.phoneUnitPrice;
  }

  public void setPhoneUnitPrice(Integer phoneUnitPrice)
  {
    this.phoneUnitPrice = phoneUnitPrice;
  }

  public String getCustBrnNo1()
  {
    return this.custBrnNo1;
  }

  public void setCustBrnNo1(String custBrnNo1)
  {
    this.custBrnNo1 = custBrnNo1;
  }

  public String getDealerName1()
  {
    return this.dealerName1;
  }

  public void setDealerName1(String dealerName1)
  {
    this.dealerName1 = dealerName1;
  }

  public Date getRegDateApproved1()
  {
    return this.regDateApproved1;
  }

  public void setRegDateApproved1(Date regDateApproved1)
  {
    this.regDateApproved1 = regDateApproved1;
  }

  public String getCustomerName()
  {
    return this.customerName;
  }

  public void setCustomerName(String customerName)
  {
    this.customerName = customerName;
  }

  public Integer getRegId1()
  {
    return this.regId1;
  }

  public void setRegId1(Integer regId1)
  {
    this.regId1 = regId1;
  }

  public String getCompanyName()
  {
    return this.companyName;
  }

  public void setCompanyName(String companyName)
  {
    this.companyName = companyName;
  }

  public String getAccMgrCode()
  {
    return this.accMgrCode;
  }

  public void setAccMgrCode(String accMgrCode)
  {
    this.accMgrCode = accMgrCode;
  }

  public String getAccountNo()
  {
    return this.accountNo;
  }

  public void setAccountNo(String accountNo)
  {
    this.accountNo = accountNo;
  }

  public String getAccountType()
  {
    return this.accountType;
  }

  public void setAccountType(String accountType)
  {
    this.accountType = accountType;
  }

  public String getAcctCategory()
  {
    return this.acctCategory;
  }

  public void setAcctCategory(String acctCategory)
  {
    this.acctCategory = acctCategory;
  }

  public String getAppealRemark()
  {
    return this.appealRemark;
  }

  public void setAppealRemark(String appealRemark)
  {
    this.appealRemark = appealRemark;
  }

  public String getApprovalRefNo()
  {
    return this.approvalRefNo;
  }

  public void setApprovalRefNo(String approvalRefNo)
  {
    this.approvalRefNo = approvalRefNo;
  }

  public String getApproverCode()
  {
    return this.approverCode;
  }

  public void setApproverCode(String approverCode)
  {
    this.approverCode = approverCode;
  }

  public String getApproverRemark()
  {
    return this.approverRemark;
  }

  public void setApproverRemark(String approverRemark)
  {
    this.approverRemark = approverRemark;
  }

  public String getApproverUserGroup()
  {
    return this.approverUserGroup;
  }

  public void setApproverUserGroup(String approverUserGroup)
  {
    this.approverUserGroup = approverUserGroup;
  }

  public String getBillInd()
  {
    return this.billInd;
  }

  public void setBillInd(String billInd)
  {
    this.billInd = billInd;
  }

  public String getCloseOrderRemark()
  {
    return this.closeOrderRemark;
  }

  public void setCloseOrderRemark(String closeOrderRemark)
  {
    this.closeOrderRemark = closeOrderRemark;
  }

  public String getCollectCode()
  {
    return this.collectCode;
  }

  public void setCollectCode(String collectCode)
  {
    this.collectCode = collectCode;
  }

  public Date getCreditDateApproved()
  {
    return this.creditDateApproved;
  }

  public void setCreditDateApproved(Date creditDateApproved)
  {
    this.creditDateApproved = creditDateApproved;
  }

  public String getCreditStatus()
  {
    return this.creditStatus;
  }

  public void setCreditStatus(String creditStatus)
  {
    this.creditStatus = creditStatus;
  }

  public String getCreditStatusCrr2()
  {
    return this.creditStatusCrr2;
  }

  public void setCreditStatusCrr2(String creditStatusCrr2)
  {
    this.creditStatusCrr2 = creditStatusCrr2;
  }

  public String getCustBrnNo()
  {
    return this.custBrnNo;
  }

  public void setCustBrnNo(String custBrnNo)
  {
    this.custBrnNo = custBrnNo;
  }

  public Integer getCustId()
  {
    return this.custId;
  }

  public void setCustId(Integer custId)
  {
    this.custId = custId;
  }

  public String getCustomerType()
  {
    return this.customerType;
  }

  public void setCustomerType(String customerType)
  {
    this.customerType = customerType;
  }

  public Date getDateAppeal()
  {
    return this.dateAppeal;
  }

  public void setDateAppeal(Date dateAppeal)
  {
    this.dateAppeal = dateAppeal;
  }

  public Date getDateCreated()
  {
    return this.dateCreated;
  }

  public void setDateCreated(Date dateCreated)
  {
    this.dateCreated = dateCreated;
  }

  public Date getDateVerified()
  {
    return this.dateVerified;
  }

  public void setDateVerified(Date dateVerified)
  {
    this.dateVerified = dateVerified;
  }

  public String getDealerCode()
  {
    return this.dealerCode;
  }

  public void setDealerCode(String dealerCode)
  {
    this.dealerCode = dealerCode;
  }

  public String getDealerName()
  {
    return this.dealerName;
  }

  public void setDealerName(String dealerName)
  {
    this.dealerName = dealerName;
  }

  public String getDonor()
  {
    return this.donor;
  }

  public void setDonor(String donor)
  {
    this.donor = donor;
  }

  public String getErrMsg()
  {
    return this.errMsg;
  }

  public void setErrMsg(String errMsg)
  {
    this.errMsg = errMsg;
  }

  public Integer getExistingLineNo()
  {
    return this.existingLineNo;
  }

  public void setExistingLineNo(Integer existingLineNo)
  {
    this.existingLineNo = existingLineNo;
  }

  public String getFinalJustification()
  {
    return this.finalJustification;
  }

  public void setFinalJustification(String finalJustification)
  {
    this.finalJustification = finalJustification;
  }

  public String getFinalRemark()
  {
    return this.finalRemark;
  }

  public void setFinalRemark(String finalRemark)
  {
    this.finalRemark = finalRemark;
  }

  public String getHireId()
  {
    return this.hireId;
  }

  public void setHireId(String hireId)
  {
    this.hireId = hireId;
  }

  public Date getLatestResubmDate()
  {
    return this.latestResubmDate;
  }

  public void setLatestResubmDate(Date latestResubmDate)
  {
    this.latestResubmDate = latestResubmDate;
  }

  public String getMarketCode()
  {
    return this.marketCode;
  }

  public void setMarketCode(String marketCode)
  {
    this.marketCode = marketCode;
  }

  public String getOrderId()
  {
    return this.orderId;
  }

  public void setOrderId(String orderId)
  {
    this.orderId = orderId;
  }

  public String getParentAcDetail()
  {
    return this.parentAcDetail;
  }

  public void setParentAcDetail(String parentAcDetail)
  {
    this.parentAcDetail = parentAcDetail;
  }

  public String getParentId()
  {
    return this.parentId;
  }

  public void setParentId(String parentId)
  {
    this.parentId = parentId;
  }

  public String getPhoneApproverId()
  {
    return this.phoneApproverId;
  }

  public void setPhoneApproverId(String phoneApproverId)
  {
    this.phoneApproverId = phoneApproverId;
  }

  public Date getPhoneCloseDate()
  {
    return this.phoneCloseDate;
  }

  public void setPhoneCloseDate(Date phoneCloseDate)
  {
    this.phoneCloseDate = phoneCloseDate;
  }

  public String getPhoneOrderStatus()
  {
    return this.phoneOrderStatus;
  }

  public void setPhoneOrderStatus(String phoneOrderStatus)
  {
    this.phoneOrderStatus = phoneOrderStatus;
  }

  public String getPortingType()
  {
    return this.portingType;
  }

  public void setPortingType(String portingType)
  {
    this.portingType = portingType;
  }

  public String getPortInStatus()
  {
    return this.portInStatus;
  }

  public void setPortInStatus(String portInStatus)
  {
    this.portInStatus = portInStatus;
  }

  public String getPromoCode()
  {
    return this.promoCode;
  }

  public void setPromoCode(String promoCode)
  {
    this.promoCode = promoCode;
  }

  public String getRegApproverCode()
  {
    return this.regApproverCode;
  }

  public void setRegApproverCode(String regApproverCode)
  {
    this.regApproverCode = regApproverCode;
  }

  public Date getRegDateApproved()
  {
    return this.regDateApproved;
  }

  public void setRegDateApproved(Date regDateApproved)
  {
    this.regDateApproved = regDateApproved;
  }

  public Integer getRegId()
  {
    return this.regId;
  }

  public void setRegId(Integer regId)
  {
    this.regId = regId;
  }

  public String getRegStatus()
  {
    return this.regStatus;
  }

  public void setRegStatus(String regStatus)
  {
    this.regStatus = regStatus;
  }

  public String getRegType()
  {
    return this.regType;
  }

  public void setRegType(String regType)
  {
    this.regType = regType;
  }

  public Integer getResubmitInd()
  {
    return this.resubmitInd;
  }

  public void setResubmitInd(Integer resubmitInd)
  {
    this.resubmitInd = resubmitInd;
  }

  public String getRouteToCode()
  {
    return this.routeToCode;
  }

  public void setRouteToCode(String routeToCode)
  {
    this.routeToCode = routeToCode;
  }

  public String getSalesmenCode()
  {
    return this.salesmenCode;
  }

  public void setSalesmenCode(String salesmenCode)
  {
    this.salesmenCode = salesmenCode;
  }

  public String getSalesmenName()
  {
    return this.salesmenName;
  }

  public void setSalesmenName(String salesmenName)
  {
    this.salesmenName = salesmenName;
  }

  public String getSourceInd()
  {
    return this.sourceInd;
  }

  public void setSourceInd(String sourceInd)
  {
    this.sourceInd = sourceInd;
  }

  public String getSubmRemark()
  {
    return this.submRemark;
  }

  public void setSubmRemark(String submRemark)
  {
    this.submRemark = submRemark;
  }

  public String getSupportCenterCode()
  {
    return this.supportCenterCode;
  }

  public void setSupportCenterCode(String supportCenterCode)
  {
    this.supportCenterCode = supportCenterCode;
  }

  public Integer getTolLineApproved()
  {
    return this.tolLineApproved;
  }

  public void setTolLineApproved(Integer tolLineApproved)
  {
    this.tolLineApproved = tolLineApproved;
  }

  public Integer getTotPhoneSubsidy()
  {
    return this.totPhoneSubsidy;
  }

  public void setTotPhoneSubsidy(Integer totPhoneSubsidy)
  {
    this.totPhoneSubsidy = totPhoneSubsidy;
  }

  public String getVasVerInd()
  {
    return this.vasVerInd;
  }

  public void setVasVerInd(String vasVerInd)
  {
    this.vasVerInd = vasVerInd;
  }

  public String getVerifierCode()
  {
    return this.verifierCode;
  }

  public void setVerifierCode(String verifierCode)
  {
    this.verifierCode = verifierCode;
  }

  public String getVerifierRemark()
  {
    return this.verifierRemark;
  }

  public void setVerifierRemark(String verifierRemark)
  {
    this.verifierRemark = verifierRemark;
  }

  public String getWsStatus()
  {
    return this.wsStatus;
  }

  public void setWsStatus(String wsStatus)
  {
    this.wsStatus = wsStatus;
  }

  public CustomerInfo getPortalCustInfo()
  {
    return this.portalCustInfo;
  }

  public void setPortalCustInfo(CustomerInfo portalCustInfo)
  {
    this.portalCustInfo = portalCustInfo;
  }

  public Date getRegDateApprovedTo()
  {
    return this.regDateApprovedTo;
  }

  public void setRegDateApprovedTo(Date regDateApprovedTo)
  {
    this.regDateApprovedTo = regDateApprovedTo;
  }

  public String getDelAddr1()
  {
    return this.delAddr1;
  }

  public void setDelAddr1(String delAddr1)
  {
    this.delAddr1 = delAddr1;
  }

  public String getDelAddr2()
  {
    return this.delAddr2;
  }

  public void setDelAddr2(String delAddr2)
  {
    this.delAddr2 = delAddr2;
  }

  public String getDelAddr3()
  {
    return this.delAddr3;
  }

  public void setDelAddr3(String delAddr3)
  {
    this.delAddr3 = delAddr3;
  }

  public String getDelPostcode()
  {
    return this.delPostcode;
  }

  public void setDelPostcode(String delPostcode)
  {
    this.delPostcode = delPostcode;
  }

  public String getDelState()
  {
    return this.delState;
  }

  public void setDelState(String delState)
  {
    this.delState = delState;
  }

  public Integer getDeliveryStatusId()
  {
    return this.deliveryStatusId;
  }

  public void setDeliveryStatusId(Integer deliveryStatusId)
  {
    this.deliveryStatusId = deliveryStatusId;
  }

  public Date getDeliveyDateTime()
  {
    return this.deliveyDateTime;
  }

  public void setDeliveyDateTime(Date deliveyDateTime)
  {
    this.deliveyDateTime = deliveyDateTime;
  }

  public Integer getOrderNo()
  {
    return this.orderNo;
  }

  public void setOrderNo(Integer orderNo)
  {
    this.orderNo = orderNo;
  }

  public String getPhoneModel()
  {
    return this.phoneModel;
  }

  public void setPhoneModel(String phoneModel)
  {
    this.phoneModel = phoneModel;
  }

  public Integer getDeviceId()
  {
    return this.deviceId;
  }

  public void setDeviceId(Integer deviceId)
  {
    this.deviceId = deviceId;
  }

  public Integer getPhoneSubsidyAmount()
  {
    return this.phoneSubsidyAmount;
  }

  public void setPhoneSubsidyAmount(Integer phoneSubsidyAmount)
  {
    this.phoneSubsidyAmount = phoneSubsidyAmount;
  }

  public Integer getPhoneTopupAmount()
  {
    return this.phoneTopupAmount;
  }

  public void setPhoneTopupAmount(Integer phoneTopupAmount)
  {
    this.phoneTopupAmount = phoneTopupAmount;
  }

  public String getVendorCode()
  {
    return this.vendorCode;
  }

  public void setVendorCode(String vendorCode)
  {
    this.vendorCode = vendorCode;
  }

  public String getAddress()
  {
    return this.delAddr1;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getFileNameUnload()
  {
    return this.fileNameUnload;
  }

  public void setFileNameUnload(String fileNameUnload)
  {
    this.fileNameUnload = fileNameUnload;
  }

  public String getFileSize()
  {
    return this.fileSize;
  }

  public void setFileSize(String fileSize)
  {
    this.fileSize = fileSize;
  }

  public Integer getSno()
  {
    return this.sno;
  }

  public void setSno(Integer sno)
  {
    this.sno = sno;
  }

  public String getUploadDocInd()
  {
    return this.uploadDocInd;
  }

  public void setUploadDocInd(String uploadDocInd)
  {
    this.uploadDocInd = uploadDocInd;
  }

  public Integer getVendorId()
  {
    return this.vendorId;
  }

  public void setVendorId(Integer vendorId)
  {
    this.vendorId = vendorId;
  }

  public Integer getSupportingCenter()
  {
    return this.supportingCenter;
  }

  public void setSupportingCenter(Integer supportingCenter)
  {
    this.supportingCenter = supportingCenter;
  }

  public String getRegStatus1()
  {
    return this.regStatus1;
  }

  public void setRegStatus1(String regStatus1)
  {
    this.regStatus1 = regStatus1;
  }

  public Integer getRemainingSubsidyAmount()
  {
    return this.remainingSubsidyAmount;
  }

  public void setRemainingSubsidyAmount(Integer remainingSubsidyAmount)
  {
    this.remainingSubsidyAmount = remainingSubsidyAmount;
  }

  public Integer getRollupId()
  {
    return this.rollupId;
  }

  public void setRollupId(Integer rollupId)
  {
    this.rollupId = rollupId;
  }

  public String getPhoneMarker()
  {
    return this.phoneMarker;
  }

  public void setPhoneMarker(String phoneMarker)
  {
    this.phoneMarker = phoneMarker;
  }

  public char getPhoneMarker1()
  {
    return this.phoneMarker1;
  }

  public void setPhoneMarker1(char phoneMarker1)
  {
    this.phoneMarker1 = phoneMarker1;
  }

  public String getDelCountry()
  {
    return this.delCountry;
  }

  public void setDelCountry(String delCountry)
  {
    this.delCountry = delCountry;
  }

  public TransMsisdn getTransMsisdn()
  {
    return this.transMsisdn;
  }

  public void setTransMsisdn(TransMsisdn transMsisdn)
  {
    this.transMsisdn = transMsisdn;
  }

  public String getRollup()
  {
    return this.rollup;
  }

  public void setRollup(String rollup)
  {
    this.rollup = rollup;
  }

  public Date getDateCreated1()
  {
    return this.dateCreated1;
  }

  public void setDateCreated1(Date dateCreated1)
  {
    this.dateCreated1 = dateCreated1;
  }

  public String getSupportingCenterName()
  {
    return this.supportingCenterName;
  }

  public void setSupportingCenterName(String supportingCenterName)
  {
    this.supportingCenterName = supportingCenterName;
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

  public String getProductName()
  {
    return this.productName;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
  }

  public String getRegBy()
  {
    return this.regBy;
  }

  public void setRegBy(String regBy)
  {
    this.regBy = regBy;
  }

  public Date getFromDate()
  {
    return this.fromDate;
  }

  public void setFromDate(Date fromDate)
  {
    this.fromDate = fromDate;
  }

  public Date getToDate()
  {
    return this.toDate;
  }

  public void setToDate(Date toDate)
  {
    this.toDate = toDate;
  }

  public String getMsisdn()
  {
    return this.msisdn;
  }

  public void setMsisdn(String msisdn)
  {
    this.msisdn = msisdn;
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

  public String getCloseBy()
  {
    return this.closeBy;
  }

  public void setCloseBy(String closeBy)
  {
    this.closeBy = closeBy;
  }

  public Date getCloseDate()
  {
    return this.closeDate;
  }

  public void setCloseDate(Date closeDate)
  {
    this.closeDate = closeDate;
  }

  public Integer getCloseStatusId()
  {
    return this.closeStatusId;
  }

  public void setCloseStatusId(Integer closeStatusId)
  {
    this.closeStatusId = closeStatusId;
  }

  public String getDeliverStatusDesc()
  {
    return this.deliverStatusDesc;
  }

  public void setDeliverStatusDesc(String deliverStatusDesc)
  {
    this.deliverStatusDesc = deliverStatusDesc;
  }

  public String getDeliveryBy()
  {
    return this.deliveryBy;
  }

  public void setDeliveryBy(String deliveryBy)
  {
    this.deliveryBy = deliveryBy;
  }

  public Integer getDeviceId1()
  {
    return this.deviceId1;
  }

  public void setDeviceId1(Integer deviceId1)
  {
    this.deviceId1 = deviceId1;
  }

  public String getDeviceName()
  {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName)
  {
    this.deviceName = deviceName;
  }

  public String getCustomerName1()
  {
    return this.customerName1;
  }

  public void setCustomerName1(String customerName1)
  {
    this.customerName1 = customerName1;
  }

  public String getCompanyName1()
  {
    return this.companyName1;
  }

  public void setCompanyName1(String companyName1)
  {
    this.companyName1 = companyName1;
  }

  public String getCloseStatusDesc()
  {
    return this.closeStatusDesc;
  }

  public void setCloseStatusDesc(String closeStatusDesc)
  {
    this.closeStatusDesc = closeStatusDesc;
  }

  public String getDealerCode1()
  {
    return this.dealerCode1;
  }

  public void setDealerCode1(String dealerCode1)
  {
    this.dealerCode1 = dealerCode1;
  }

  public String getAddress1()
  {
    return this.address1;
  }

  public void setAddress1(String address1)
  {
    this.address1 = address1;
  }

  public String getAddress2()
  {
    return this.address2;
  }

  public void setAddress2(String address2)
  {
    this.address2 = address2;
  }

  public String getCity()
  {
    return this.city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getCountry_name()
  {
    return this.country_name;
  }

  public void setCountry_name(String country_name)
  {
    this.country_name = country_name;
  }

  public Integer getCountryId()
  {
    return this.countryId;
  }

  public void setCountryId(Integer countryId)
  {
    this.countryId = countryId;
  }

  public String getPostCode()
  {
    return this.postCode;
  }

  public void setPostCode(String postCode)
  {
    this.postCode = postCode;
  }

  public String getState()
  {
    return this.state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  public String getDelContactIc()
  {
    return this.delContactIc;
  }

  public void setDelContactIc(String delContactIc)
  {
    this.delContactIc = delContactIc;
  }

  public String getDelContactName()
  {
    return this.delContactName;
  }

  public void setDelContactName(String delContactName)
  {
    this.delContactName = delContactName;
  }

  public String getDelContactPhoneNo()
  {
    return this.delContactPhoneNo;
  }

  public void setDelContactPhoneNo(String delContactPhoneNo)
  {
    this.delContactPhoneNo = delContactPhoneNo;
  }

  public Integer getRoadshowId()
  {
    return this.roadshowId;
  }

  public void setRoadshowId(Integer roadshowId)
  {
    this.roadshowId = roadshowId;
  }

  public Integer getRoadshowId1()
  {
    return this.roadshowId1;
  }

  public void setRoadshowId1(Integer roadshowId1)
  {
    this.roadshowId1 = roadshowId1;
  }

  public Date getSubsidyExpiryDate()
  {
    return this.subsidyExpiryDate;
  }

  public void setSubsidyExpiryDate(Date subsidyExpiryDate)
  {
    this.subsidyExpiryDate = subsidyExpiryDate;
  }

  public Date getSubsidyExpiryDate1()
  {
    return this.subsidyExpiryDate1;
  }

  public void setSubsidyExpiryDate1(Date subsidyExpiryDate1)
  {
    this.subsidyExpiryDate1 = subsidyExpiryDate1;
  }

  public String getMycard()
  {
    return this.mycard;
  }

  public void setMycard(String mycard)
  {
    this.mycard = mycard;
  }

  public String getFileName_1()
  {
    return this.fileName_1;
  }

  public void setFileName_1(String fileName_1)
  {
    this.fileName_1 = fileName_1;
  }

  public String getFileName_2()
  {
    return this.fileName_2;
  }

  public void setFileName_2(String fileName_2)
  {
    this.fileName_2 = fileName_2;
  }

  public String getFileName_3()
  {
    return this.fileName_3;
  }

  public void setFileName_3(String fileName_3)
  {
    this.fileName_3 = fileName_3;
  }

  public String getFileName_4()
  {
    return this.fileName_4;
  }

  public void setFileName_4(String fileName_4)
  {
    this.fileName_4 = fileName_4;
  }

  public String getFileName_5()
  {
    return this.fileName_5;
  }

  public void setFileName_5(String fileName_5)
  {
    this.fileName_5 = fileName_5;
  }

  public String getFileName_6()
  {
    return this.fileName_6;
  }

  public void setFileName_6(String fileName_6)
  {
    this.fileName_6 = fileName_6;
  }

  public String getFileName_7()
  {
    return this.fileName_7;
  }

  public void setFileName_7(String fileName_7)
  {
    this.fileName_7 = fileName_7;
  }

  public String getFileName_8()
  {
    return this.fileName_8;
  }

  public void setFileName_8(String fileName_8)
  {
    this.fileName_8 = fileName_8;
  }

  public String getFileName_9()
  {
    return this.fileName_9;
  }

  public void setFileName_9(String fileName_9)
  {
    this.fileName_9 = fileName_9;
  }

  public String getMqStatus()
  {
    return this.mqStatus;
  }

  public void setMqStatus(String mqStatus)
  {
    this.mqStatus = mqStatus;
  }

  public Integer getTempTotalSubsidyAmt()
  {
    return this.tempTotalSubsidyAmt;
  }

  public void setTempTotalSubsidyAmt(Integer tempTotalSubsidyAmt)
  {
    this.tempTotalSubsidyAmt = tempTotalSubsidyAmt;
  }

  public String getAddress1SiteA()
  {
    return this.address1SiteA;
  }

  public void setAddress1SiteA(String address1SiteA)
  {
    this.address1SiteA = address1SiteA;
  }

  public String getAddress1SiteB()
  {
    return this.address1SiteB;
  }

  public void setAddress1SiteB(String address1SiteB)
  {
    this.address1SiteB = address1SiteB;
  }

  public String getAddress2SiteA()
  {
    return this.address2SiteA;
  }

  public void setAddress2SiteA(String address2SiteA)
  {
    this.address2SiteA = address2SiteA;
  }

  public String getAddress2SiteB()
  {
    return this.address2SiteB;
  }

  public void setAddress2SiteB(String address2SiteB)
  {
    this.address2SiteB = address2SiteB;
  }

  public String getAddress3SiteA()
  {
    return this.address3SiteA;
  }

  public void setAddress3SiteA(String address3SiteA)
  {
    this.address3SiteA = address3SiteA;
  }

  public String getAddress3SiteB()
  {
    return this.address3SiteB;
  }

  public void setAddress3SiteB(String address3SiteB)
  {
    this.address3SiteB = address3SiteB;
  }

  public String getBuildingSiteA()
  {
    return this.buildingSiteA;
  }

  public void setBuildingSiteA(String buildingSiteA)
  {
    this.buildingSiteA = buildingSiteA;
  }

  public String getBuildingSiteB()
  {
    return this.buildingSiteB;
  }

  public void setBuildingSiteB(String buildingSiteB)
  {
    this.buildingSiteB = buildingSiteB;
  }

  public String getCitySiteA()
  {
    return this.citySiteA;
  }

  public void setCitySiteA(String citySiteA)
  {
    this.citySiteA = citySiteA;
  }

  public String getCitySiteB()
  {
    return this.citySiteB;
  }

  public void setCitySiteB(String citySiteB)
  {
    this.citySiteB = citySiteB;
  }

  public String getContactNameSiteA()
  {
    return this.contactNameSiteA;
  }

  public void setContactNameSiteA(String contactNameSiteA)
  {
    this.contactNameSiteA = contactNameSiteA;
  }

  public String getContactNameSiteB()
  {
    return this.contactNameSiteB;
  }

  public void setContactNameSiteB(String contactNameSiteB)
  {
    this.contactNameSiteB = contactNameSiteB;
  }

  public String getContactNumberSiteA()
  {
    return this.contactNumberSiteA;
  }

  public void setContactNumberSiteA(String contactNumberSiteA)
  {
    this.contactNumberSiteA = contactNumberSiteA;
  }

  public String getContactNumberSiteB()
  {
    return this.contactNumberSiteB;
  }

  public void setContactNumberSiteB(String contactNumberSiteB)
  {
    this.contactNumberSiteB = contactNumberSiteB;
  }

  public String getCountrySiteA()
  {
    return this.countrySiteA;
  }

  public void setCountrySiteA(String countrySiteA)
  {
    this.countrySiteA = countrySiteA;
  }

  public String getCountrySiteB()
  {
    return this.countrySiteB;
  }

  public void setCountrySiteB(String countrySiteB)
  {
    this.countrySiteB = countrySiteB;
  }

  public String getEmailSiteA()
  {
    return this.emailSiteA;
  }

  public void setEmailSiteA(String emailSiteA)
  {
    this.emailSiteA = emailSiteA;
  }

  public String getEmailSiteB()
  {
    return this.emailSiteB;
  }

  public void setEmailSiteB(String emailSiteB)
  {
    this.emailSiteB = emailSiteB;
  }

  public String getFaxNoSiteA()
  {
    return this.faxNoSiteA;
  }

  public void setFaxNoSiteA(String faxNoSiteA)
  {
    this.faxNoSiteA = faxNoSiteA;
  }

  public String getFaxNoSiteB()
  {
    return this.faxNoSiteB;
  }

  public void setFaxNoSiteB(String faxNoSiteB)
  {
    this.faxNoSiteB = faxNoSiteB;
  }

  public String getMobileNumberSiteA()
  {
    return this.mobileNumberSiteA;
  }

  public void setMobileNumberSiteA(String mobileNumberSiteA)
  {
    this.mobileNumberSiteA = mobileNumberSiteA;
  }

  public String getMobileNumberSiteB()
  {
    return this.mobileNumberSiteB;
  }

  public void setMobileNumberSiteB(String mobileNumberSiteB)
  {
    this.mobileNumberSiteB = mobileNumberSiteB;
  }

  public String getPostCodeSiteA()
  {
    return this.postCodeSiteA;
  }

  public void setPostCodeSiteA(String postCodeSiteA)
  {
    this.postCodeSiteA = postCodeSiteA;
  }

  public String getPostCodeSiteB()
  {
    return this.postCodeSiteB;
  }

  public void setPostCodeSiteB(String postCodeSiteB)
  {
    this.postCodeSiteB = postCodeSiteB;
  }

  public String getStateSiteA()
  {
    return this.stateSiteA;
  }

  public void setStateSiteA(String stateSiteA)
  {
    this.stateSiteA = stateSiteA;
  }

  public String getStateSiteB()
  {
    return this.stateSiteB;
  }

  public void setStateSiteB(String stateSiteB)
  {
    this.stateSiteB = stateSiteB;
  }

  public String getCmssno()
  {
    return this.cmssno;
  }

  public void setCmssno(String cmssno)
  {
    this.cmssno = cmssno;
  }

  public String getSofno()
  {
    return this.sofno;
  }

  public void setSofno(String sofno)
  {
    this.sofno = sofno;
  }

  public String getCreatedBy()
  {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy)
  {
    this.createdBy = createdBy;
  }

  public String getModifiedBy()
  {
    return this.modifiedBy;
  }

  public void setModifiedBy(String modifiedBy)
  {
    this.modifiedBy = modifiedBy;
  }

  public Integer getPromotionId()
  {
    return this.promotionId;
  }

  public void setPromotionId(Integer promotionId)
  {
    this.promotionId = promotionId;
  }

  public String getDeviceName1()
  {
    return this.deviceName1;
  }

  public void setDeviceName1(String deviceName1)
  {
    this.deviceName1 = deviceName1;
  }

  public String getMaxisRfStatus2()
  {
    return this.maxisRfStatus2;
  }

  public void setMaxisRfStatus2(String maxisRfStatus2)
  {
    this.maxisRfStatus2 = maxisRfStatus2;
  }

  public String getCreatedByMsisdn()
  {
    return this.createdByMsisdn;
  }

  public void setCreatedByMsisdn(String createdByMsisdn)
  {
    this.createdByMsisdn = createdByMsisdn;
  }

  public Date getDateCreatedMsisdn()
  {
    return this.dateCreatedMsisdn;
  }

  public void setDateCreatedMsisdn(Date dateCreatedMsisdn)
  {
    this.dateCreatedMsisdn = dateCreatedMsisdn;
  }

  public String getCreatedRemarks()
  {
    return this.createdRemarks;
  }

  public void setCreatedRemarks(String createdRemarks)
  {
    this.createdRemarks = createdRemarks;
  }

  public Integer getTotPhoneSubsidy1()
  {
    return this.totPhoneSubsidy1;
  }

  public void setTotPhoneSubsidy1(Integer totPhoneSubsidy1)
  {
    this.totPhoneSubsidy1 = totPhoneSubsidy1;
  }

  public String getRegStatus2()
  {
    return this.regStatus2;
  }

  public void setRegStatus2(String regStatus2)
  {
    this.regStatus2 = regStatus2;
  }

  public String getAccountNo1()
  {
    return this.accountNo1;
  }

  public void setAccountNo1(String accountNo1)
  {
    this.accountNo1 = accountNo1;
  }

  public Integer getDeliveryStatusId1()
  {
    return this.deliveryStatusId1;
  }

  public void setDeliveryStatusId1(Integer deliveryStatusId1)
  {
    this.deliveryStatusId1 = deliveryStatusId1;
  }

public Integer getProdCatId() {
	return prodCatId;
}

public void setProdCatId(Integer prodCatId) {
	this.prodCatId = prodCatId;
}
}
