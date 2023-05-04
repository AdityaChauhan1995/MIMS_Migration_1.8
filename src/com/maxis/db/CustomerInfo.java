package com.maxis.db;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer custId;
  private String custBrnNo;
  private String acctManagerDealerCode;
  public String getAcctManagerDealerCode() {
	return acctManagerDealerCode;
}

public void setAcctManagerDealerCode(String acctManagerDealerCode) {
	this.acctManagerDealerCode = acctManagerDealerCode;
}

private String companyName;
  private String companyTypeCode;
  private String businessNature;
  private String staffStrength;
  private String custPuc;
  private String custRoc;
  private String custRevTurnover;
  private String custPnl;
  private String custCompCharges;
  private String custFinalRemark;
  private String appealRemark;
  private Integer preApprovedLine;
  private String billAddr1;
  private String billAddr2;
  private String billAddr3;
  private String billState;
  private String billPostcode;
  private String billCountry;
  private String billCountryName;
  private String delAddr1;
  private String delAddr2;
  private String delAddr3;
  private String delState;
  private String delPostcode;
  private String delCountry;
  private String delCountryName;
  private String dealerCode;
  private String dealerName;
  private Date dateCreated;
  private String dealerRemark;
  private String title;
  private String custName;
  private Date dob;
  private String gender;
  private String oldIc;
  private String newIc;
  private String email;
  private String contactNo;
  private String faxNo;
  private String tenteraNo;
  private String passportNo;
  private String nationality;
  private String race;
  private String prefLang;
  private String picName;
  private String picIc;
  private String picFaxNo;
  private String picEmail;
  private String picPhoneNo;
  private String picMobileNo;
  private String delContactName;
  private String delContactIc;
  private String delContactPhoneNo;
  private PortalRegistrationMaster portalRegistrationMaster;
  private CustomerInfo customerInfo;
  private List deviceListForPhoneOrder;
  private List deviceListForPhoneOrderReg;
  private List transVasList;
  private List transMsisdnList;
  private List billableListForBilling;
  private List tempRegDocList;
  private String tempRegId;
  private String regIdForPhoneOrder;
  private String docType;
  private String companyCodeName;
  private String userRole;
  private String tempUploadRegId;
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
  private String businessName;
  private String staffId;
  private String accMgrCode;
  private String delContactFixNo;
  
  private String secondaryPicName;
  private String secondaryPicContactNo;
  private String secondaryPicEmail;
  private String secondaryPicIc;
  
  public String getSecondaryPicName() {
	return secondaryPicName;
}

public void setSecondaryPicName(String secondaryPicName) {
	this.secondaryPicName = secondaryPicName;
}

public String getSecondaryPicContactNo() {
	return secondaryPicContactNo;
}

public void setSecondaryPicContactNo(String secondaryPicContactNo) {
	this.secondaryPicContactNo = secondaryPicContactNo;
}

public String getSecondaryPicEmail() {
	return secondaryPicEmail;
}

public void setSecondaryPicEmail(String secondaryPicEmail) {
	this.secondaryPicEmail = secondaryPicEmail;
}

public String getSecondaryPicIc() {
	return secondaryPicIc;
}

public void setSecondaryPicIc(String secondaryPicIc) {
	this.secondaryPicIc = secondaryPicIc;
}

public String getDelContactFixNo() {
	return delContactFixNo;
}

public void setDelContactFixNo(String delContactFixNo) {
	this.delContactFixNo = delContactFixNo;
}

public String getAccMgrCode() {
	return accMgrCode;
}

public void setAccMgrCode(String accMgrCode) {
	this.accMgrCode = accMgrCode;
}

public String getBusinessName()
  {
    return this.businessName;
  }

  public void setBusinessName(String businessName)
  {
    this.businessName = businessName;
  }

  public String getUserRole()
  {
    return this.userRole;
  }

  public void setUserRole(String userRole)
  {
    this.userRole = userRole;
  }

  public String getCompanyCodeName()
  {
    return this.companyCodeName;
  }

  public void setCompanyCodeName(String companyCodeName)
  {
    this.companyCodeName = companyCodeName;
  }

  public String getDocType()
  {
    return this.docType;
  }

  public void setDocType(String docType)
  {
    this.docType = docType;
  }

  public String getAppealRemark()
  {
    return this.appealRemark;
  }

  public void setAppealRemark(String appealRemark)
  {
    this.appealRemark = appealRemark;
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

  public String getBusinessNature()
  {
    return this.businessNature;
  }

  public void setBusinessNature(String businessNature)
  {
    this.businessNature = businessNature;
  }

  public String getCompanyName()
  {
    return this.companyName;
  }

  public void setCompanyName(String companyName)
  {
    this.companyName = companyName;
  }

  public String getCompanyTypeCode()
  {
    return this.companyTypeCode;
  }

  public void setCompanyTypeCode(String companyTypeCode)
  {
    this.companyTypeCode = companyTypeCode;
  }

  public String getContactNo()
  {
    return this.contactNo;
  }

  public void setContactNo(String contactNo)
  {
    this.contactNo = contactNo;
  }

  public String getCustBrnNo()
  {
    return this.custBrnNo;
  }

  public void setCustBrnNo(String custBrnNo)
  {
    this.custBrnNo = custBrnNo;
  }

  public String getCustCompCharges()
  {
    return this.custCompCharges;
  }

  public void setCustCompCharges(String custCompCharges)
  {
    this.custCompCharges = custCompCharges;
  }

  public String getCustFinalRemark()
  {
    return this.custFinalRemark;
  }

  public void setCustFinalRemark(String custFinalRemark)
  {
    this.custFinalRemark = custFinalRemark;
  }

  public Integer getCustId()
  {
    return this.custId;
  }

  public void setCustId(Integer custId)
  {
    this.custId = custId;
  }

  public String getCustName()
  {
    return this.custName;
  }

  public void setCustName(String custName)
  {
    this.custName = custName;
  }

  public String getCustPnl()
  {
    return this.custPnl;
  }

  public void setCustPnl(String custPnl)
  {
    this.custPnl = custPnl;
  }

  public String getCustPuc()
  {
    return this.custPuc;
  }

  public void setCustPuc(String custPuc)
  {
    this.custPuc = custPuc;
  }

  public String getCustRevTurnover()
  {
    return this.custRevTurnover;
  }

  public void setCustRevTurnover(String custRevTurnover)
  {
    this.custRevTurnover = custRevTurnover;
  }

  public String getCustRoc()
  {
    return this.custRoc;
  }

  public void setCustRoc(String custRoc)
  {
    this.custRoc = custRoc;
  }

  public Date getDateCreated()
  {
    return this.dateCreated;
  }

  public void setDateCreated(Date dateCreated)
  {
    this.dateCreated = dateCreated;
  }

  public String getDealerCode()
  {
    return this.dealerCode;
  }

  public void setDealerCode(String dealerCode)
  {
    this.dealerCode = dealerCode;
  }

  public String getDealerRemark()
  {
    return this.dealerRemark;
  }

  public void setDealerRemark(String dealerRemark)
  {
    this.dealerRemark = dealerRemark;
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

  public String getDelCountry()
  {
    return this.delCountry;
  }

  public void setDelCountry(String delCountry)
  {
    this.delCountry = delCountry;
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

  public Date getDob()
  {
    return this.dob;
  }

  public void setDob(Date dob)
  {
    this.dob = dob;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getFaxNo()
  {
    return this.faxNo;
  }

  public void setFaxNo(String faxNo)
  {
    this.faxNo = faxNo;
  }

  public String getGender()
  {
    return this.gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  public String getNationality()
  {
    return this.nationality;
  }

  public void setNationality(String nationality)
  {
    this.nationality = nationality;
  }

  public String getNewIc()
  {
    return this.newIc;
  }

  public void setNewIc(String newIc)
  {
    this.newIc = newIc;
  }

  public String getOldIc()
  {
    return this.oldIc;
  }

  public void setOldIc(String oldIc)
  {
    this.oldIc = oldIc;
  }

  public String getPassportNo()
  {
    return this.passportNo;
  }

  public void setPassportNo(String passportNo)
  {
    this.passportNo = passportNo;
  }

  public String getPicEmail()
  {
    return this.picEmail;
  }

  public void setPicEmail(String picEmail)
  {
    this.picEmail = picEmail;
  }

  public String getPicFaxNo()
  {
    return this.picFaxNo;
  }

  public void setPicFaxNo(String picFaxNo)
  {
    this.picFaxNo = picFaxNo;
  }

  public String getPicIc()
  {
    return this.picIc;
  }

  public void setPicIc(String picIc)
  {
    this.picIc = picIc;
  }

  public String getPicMobileNo()
  {
    return this.picMobileNo;
  }

  public void setPicMobileNo(String picMobileNo)
  {
    this.picMobileNo = picMobileNo;
  }

  public String getPicName()
  {
    return this.picName;
  }

  public void setPicName(String picName)
  {
    this.picName = picName;
  }

  public String getPicPhoneNo()
  {
    return this.picPhoneNo;
  }

  public void setPicPhoneNo(String picPhoneNo)
  {
    this.picPhoneNo = picPhoneNo;
  }

  public Integer getPreApprovedLine()
  {
    return this.preApprovedLine;
  }

  public void setPreApprovedLine(Integer preApprovedLine)
  {
    this.preApprovedLine = preApprovedLine;
  }

  public String getPrefLang()
  {
    return this.prefLang;
  }

  public void setPrefLang(String prefLang)
  {
    this.prefLang = prefLang;
  }

  public String getRace()
  {
    return this.race;
  }

  public void setRace(String race)
  {
    this.race = race;
  }

  public String getStaffStrength()
  {
    return this.staffStrength;
  }

  public void setStaffStrength(String staffStrength)
  {
    this.staffStrength = staffStrength;
  }

  public String getTenteraNo()
  {
    return this.tenteraNo;
  }

  public void setTenteraNo(String tenteraNo)
  {
    this.tenteraNo = tenteraNo;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public List getBillableListForBilling()
  {
    return this.billableListForBilling;
  }

  public void setBillableListForBilling(List billableListForBilling)
  {
    this.billableListForBilling = billableListForBilling;
  }

  public List getDeviceListForPhoneOrder()
  {
    return this.deviceListForPhoneOrder;
  }

  public void setDeviceListForPhoneOrder(List deviceListForPhoneOrder)
  {
    this.deviceListForPhoneOrder = deviceListForPhoneOrder;
  }

  public List getDeviceListForPhoneOrderReg()
  {
    return this.deviceListForPhoneOrderReg;
  }

  public void setDeviceListForPhoneOrderReg(List deviceListForPhoneOrderReg)
  {
    this.deviceListForPhoneOrderReg = deviceListForPhoneOrderReg;
  }

  public PortalRegistrationMaster getPortalRegistrationMaster()
  {
    return this.portalRegistrationMaster;
  }

  public void setPortalRegistrationMaster(PortalRegistrationMaster portalRegistrationMaster)
  {
    this.portalRegistrationMaster = portalRegistrationMaster;
  }

  public List getTransMsisdnList()
  {
    return this.transMsisdnList;
  }

  public void setTransMsisdnList(List transMsisdnList)
  {
    this.transMsisdnList = transMsisdnList;
  }

  public List getTransVasList()
  {
    return this.transVasList;
  }

  public void setTransVasList(List transVasList)
  {
    this.transVasList = transVasList;
  }

  public String getDealerName()
  {
    return this.dealerName;
  }

  public void setDealerName(String dealerName)
  {
    this.dealerName = dealerName;
  }

  public List getTempRegDocList()
  {
    return this.tempRegDocList;
  }

  public void setTempRegDocList(List tempRegDocList)
  {
    this.tempRegDocList = tempRegDocList;
  }

  public String getTempRegId()
  {
    return this.tempRegId;
  }

  public void setTempRegId(String tempRegId)
  {
    this.tempRegId = tempRegId;
  }

  public String getRegIdForPhoneOrder()
  {
    return this.regIdForPhoneOrder;
  }

  public void setRegIdForPhoneOrder(String regIdForPhoneOrder)
  {
    this.regIdForPhoneOrder = regIdForPhoneOrder;
  }

  public String getTempUploadRegId()
  {
    return this.tempUploadRegId;
  }

  public void setTempUploadRegId(String tempUploadRegId)
  {
    this.tempUploadRegId = tempUploadRegId;
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

  public String getBillCountryName()
  {
    return this.billCountryName;
  }

  public void setBillCountryName(String billCountryName)
  {
    this.billCountryName = billCountryName;
  }

  public String getDelCountryName()
  {
    return this.delCountryName;
  }

  public void setDelCountryName(String delCountryName)
  {
    this.delCountryName = delCountryName;
  }

  public String getStaffId()
  {
    return this.staffId;
  }

  public void setStaffId(String staffId)
  {
    this.staffId = staffId;
  }

  public CustomerInfo getCustomerInfo()
  {
    return this.customerInfo;
  }

  public void setCustomerInfo(CustomerInfo customerInfo)
  {
    this.customerInfo = customerInfo;
  }
}
