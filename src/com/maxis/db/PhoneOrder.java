package com.maxis.db;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PhoneOrder
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer orderNo;
  private Date deliveyDateTime;
  private Integer deliveryStatusId;
  private String deliveryRemark;
  private String imei;
  private String phoneModel;
  private Integer orderNo1;
  private Integer deviceId;
  private Integer brandId;
  private Integer subsidyPrice;
  private Integer topup;
  private Integer iphoneTopup;
  private Integer iphoneSubsidy;
  private String unusedRegIds;
  private Integer unitPrice;
  private int rowNo;
  private String regIdStr;
  private String deliverStatusName;
  private String conditionCheckParm;
  private Date mimsSubmitDate;
  private Integer phoneUnitPrice;
  private Integer phoneSubsidyAmount;
  private Integer phoneTopupAmount;
  private String serialNo;
  private String vendorCode;
  private Date orderDateTime;
  private String verifiedBy;
  private Date deliveredDateTime;
  private Integer phoneSubsidyBalance;
  private String uploadDoc;
  private String uploadDocInd;
  private String fileNameUnload;
  private String coName;
  private String fileNameUnload22;
  private String fileSize;
  private byte[] fileContent;
  private Integer vendorId;
  private String deviceName;
  private String deviceName1;
  private String vendorName;
  public List phoneOrderList;
  private Date dateCreated;
  private Date dateModified;
  private String createdBy;
  private String modifiedBy;
  private Integer totalAmount;
  private String brandName;
  private Integer sno;
  private Integer sno1;
  private String deliverStatusDesc;
  private Integer closeStatusId;
  private String closeBy;
  private Date closeDate;
  private String closeRemark;
  private String deliveryBy;
  private Integer regId;
  private String closeStatusDesc;
  private Date invoiceDate;
  private Integer invoiceNo;
  private String invoiceBy;
  private Integer deliverStatusId;
  private Integer TransRegId;
  private Integer dealerCode;
  private String delButton;
  private Integer deliveryStatusIdRadio;
  private Integer colorId;
  private String wsAcct;
  private Date verifiedDate;
  private String verifiedRemark;
  private String msisdn;
  private String createdByMsisdn;
  private String dateCreatedMsisdn;
  private String roleName;
  private String onsiteF;
  private String delAddr1;
  private String delAddr2;
  private String delAddr3;
  private String delState;
  private String delPostcode;
  private String delCountry;
  private String multipleAddress;
  private Integer transMsid;
  private String createRemarks;
  private String regType;
  private String deliveryAddressButton;

  public String getPhoneModel()
  {
    return this.phoneModel;
  }

  public void setPhoneModel(String phoneModel)
  {
    this.phoneModel = phoneModel;
  }

  public Integer getOrderNo()
  {
    return this.orderNo;
  }

  public void setOrderNo(Integer orderNo)
  {
    this.orderNo = orderNo;
  }

  public Integer getOrderNo1()
  {
    return this.orderNo1;
  }

  public void setOrderNo1(Integer orderNo1)
  {
    this.orderNo1 = orderNo1;
  }

  public Integer getDeviceId()
  {
    return this.deviceId;
  }

  public void setDeviceId(Integer deviceId)
  {
    this.deviceId = deviceId;
  }

  public Integer getBrandId()
  {
    return this.brandId;
  }

  public void setBrandId(Integer brandId)
  {
    this.brandId = brandId;
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

  public Integer getIphoneTopup()
  {
    return this.iphoneTopup;
  }

  public void setIphoneTopup(Integer iphoneTopup)
  {
    this.iphoneTopup = iphoneTopup;
  }

  public Integer getIphoneSubsidy()
  {
    return this.iphoneSubsidy;
  }

  public void setIphoneSubsidy(Integer iphoneSubsidy)
  {
    this.iphoneSubsidy = iphoneSubsidy;
  }

  public String getUnusedRegIds()
  {
    return this.unusedRegIds;
  }

  public void setUnusedRegIds(String unusedRegIds)
  {
    this.unusedRegIds = unusedRegIds;
  }

  public Integer getUnitPrice()
  {
    return this.unitPrice;
  }

  public void setUnitPrice(Integer unitPrice)
  {
    this.unitPrice = unitPrice;
  }

  public int getRowNo()
  {
    return this.rowNo;
  }

  public void setRowNo(int rowNo)
  {
    this.rowNo = rowNo;
  }

  public String getRegIdStr()
  {
    return this.regIdStr;
  }

  public void setRegIdStr(String regIdStr)
  {
    this.regIdStr = regIdStr;
  }

  public String getDeliverStatusName()
  {
    return this.deliverStatusName;
  }

  public void setDeliverStatusName(String deliverStatusName)
  {
    this.deliverStatusName = deliverStatusName;
  }

  public String getConditionCheckParm()
  {
    return this.conditionCheckParm;
  }

  public void setConditionCheckParm(String conditionCheckParm)
  {
    this.conditionCheckParm = conditionCheckParm;
  }

  public Date getMimsSubmitDate()
  {
    return this.mimsSubmitDate;
  }

  public void setMimsSubmitDate(Date mimsSubmitDate)
  {
    this.mimsSubmitDate = mimsSubmitDate;
  }

  public Integer getPhoneUnitPrice()
  {
    return this.phoneUnitPrice;
  }

  public void setPhoneUnitPrice(Integer phoneUnitPrice)
  {
    this.phoneUnitPrice = phoneUnitPrice;
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

  public String getSerialNo()
  {
    return this.serialNo;
  }

  public void setSerialNo(String serialNo)
  {
    this.serialNo = serialNo;
  }

  public String getVendorCode()
  {
    return this.vendorCode;
  }

  public void setVendorCode(String vendorCode)
  {
    this.vendorCode = vendorCode;
  }

  public Integer getDeliveryStatusId()
  {
    return this.deliveryStatusId;
  }

  public void setDeliveryStatusId(Integer deliveryStatusId)
  {
    this.deliveryStatusId = deliveryStatusId;
  }

  public Date getOrderDateTime()
  {
    return this.orderDateTime;
  }

  public void setOrderDateTime(Date orderDateTime)
  {
    this.orderDateTime = orderDateTime;
  }

  public String getVerifiedBy()
  {
    return this.verifiedBy;
  }

  public void setVerifiedBy(String verifiedBy)
  {
    this.verifiedBy = verifiedBy;
  }

  public Date getDeliveredDateTime()
  {
    return this.deliveredDateTime;
  }

  public void setDeliveredDateTime(Date deliveredDateTime)
  {
    this.deliveredDateTime = deliveredDateTime;
  }

  public Date getDeliveyDateTime()
  {
    return this.deliveyDateTime;
  }

  public void setDeliveyDateTime(Date deliveyDateTime)
  {
    this.deliveyDateTime = deliveyDateTime;
  }

  public Integer getPhoneSubsidyBalance()
  {
    return this.phoneSubsidyBalance;
  }

  public void setPhoneSubsidyBalance(Integer phoneSubsidyBalance)
  {
    this.phoneSubsidyBalance = phoneSubsidyBalance;
  }

  public String getUploadDoc()
  {
    return this.uploadDoc;
  }

  public void setUploadDoc(String uploadDoc)
  {
    this.uploadDoc = uploadDoc;
  }

  public String getUploadDocInd()
  {
    return this.uploadDocInd;
  }

  public void setUploadDocInd(String uploadDocInd)
  {
    this.uploadDocInd = uploadDocInd;
  }

  public String getFileNameUnload()
  {
    return this.fileNameUnload;
  }

  public void setFileNameUnload(String fileNameUnload)
  {
    this.fileNameUnload = fileNameUnload;
  }

  public String getCoName()
  {
    return this.coName;
  }

  public void setCoName(String coName)
  {
    this.coName = coName;
  }

  public String getFileNameUnload22()
  {
    return this.fileNameUnload22;
  }

  public void setFileNameUnload22(String fileNameUnload22)
  {
    this.fileNameUnload22 = fileNameUnload22;
  }

  public String getDeliveryRemark()
  {
    return this.deliveryRemark;
  }

  public void setDeliveryRemark(String deliveryRemark)
  {
    this.deliveryRemark = deliveryRemark;
  }

  public String getFileSize()
  {
    return this.fileSize;
  }

  public void setFileSize(String fileSize)
  {
    this.fileSize = fileSize;
  }

  public byte[] getFileContent()
  {
    return this.fileContent;
  }

  public void setFileContent(byte[] fileContent)
  {
    this.fileContent = fileContent;
  }

  public Integer getVendorId()
  {
    return this.vendorId;
  }

  public void setVendorId(Integer vendorId)
  {
    this.vendorId = vendorId;
  }

  public String getDeviceName()
  {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName)
  {
    this.deviceName = deviceName;
  }

  public String getDeviceName1()
  {
    return this.deviceName1;
  }

  public void setDeviceName1(String deviceName1)
  {
    this.deviceName1 = deviceName1;
  }

  public String getVendorName()
  {
    return this.vendorName;
  }

  public void setVendorName(String vendorName)
  {
    this.vendorName = vendorName;
  }

  public List getPhoneOrderList()
  {
    return this.phoneOrderList;
  }

  public void setPhoneOrderList(List phoneOrderList)
  {
    this.phoneOrderList = phoneOrderList;
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

  public Integer getTotalAmount()
  {
    return this.totalAmount;
  }

  public void setTotalAmount(Integer totalAmount)
  {
    this.totalAmount = totalAmount;
  }

  public String getBrandName()
  {
    return this.brandName;
  }

  public void setBrandName(String brandName)
  {
    this.brandName = brandName;
  }

  public Integer getSno()
  {
    return this.sno;
  }

  public void setSno(Integer sno)
  {
    this.sno = sno;
  }

  public Integer getSno1()
  {
    return this.sno1;
  }

  public void setSno1(Integer sno1)
  {
    this.sno1 = sno1;
  }

  public String getDeliverStatusDesc()
  {
    return this.deliverStatusDesc;
  }

  public void setDeliverStatusDesc(String deliverStatusDesc)
  {
    this.deliverStatusDesc = deliverStatusDesc;
  }

  public Integer getCloseStatusId()
  {
    return this.closeStatusId;
  }

  public void setCloseStatusId(Integer closeStatusId)
  {
    this.closeStatusId = closeStatusId;
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

  public String getCloseRemark()
  {
    return this.closeRemark;
  }

  public void setCloseRemark(String closeRemark)
  {
    this.closeRemark = closeRemark;
  }

  public String getDeliveryBy()
  {
    return this.deliveryBy;
  }

  public void setDeliveryBy(String deliveryBy)
  {
    this.deliveryBy = deliveryBy;
  }

  public Integer getRegId()
  {
    return this.regId;
  }

  public void setRegId(Integer regId)
  {
    this.regId = regId;
  }

  public String getCloseStatusDesc()
  {
    return this.closeStatusDesc;
  }

  public void setCloseStatusDesc(String closeStatusDesc)
  {
    this.closeStatusDesc = closeStatusDesc;
  }

  public Date getInvoiceDate()
  {
    return this.invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate)
  {
    this.invoiceDate = invoiceDate;
  }

  public Integer getInvoiceNo()
  {
    return this.invoiceNo;
  }

  public void setInvoiceNo(Integer invoiceNo)
  {
    this.invoiceNo = invoiceNo;
  }

  public String getInvoiceBy()
  {
    return this.invoiceBy;
  }

  public void setInvoiceBy(String invoiceBy)
  {
    this.invoiceBy = invoiceBy;
  }

  public Integer getDeliverStatusId()
  {
    return this.deliverStatusId;
  }

  public void setDeliverStatusId(Integer deliverStatusId)
  {
    this.deliverStatusId = deliverStatusId;
  }

  public Integer getTransRegId()
  {
    return this.TransRegId;
  }

  public void setTransRegId(Integer transRegId)
  {
    this.TransRegId = transRegId;
  }

  public Integer getDealerCode()
  {
    return this.dealerCode;
  }

  public void setDealerCode(Integer dealerCode)
  {
    this.dealerCode = dealerCode;
  }

  public String getDelButton()
  {
    return this.delButton;
  }

  public void setDelButton(String delButton)
  {
    this.delButton = delButton;
  }

  public Integer getDeliveryStatusIdRadio()
  {
    return this.deliveryStatusIdRadio;
  }

  public void setDeliveryStatusIdRadio(Integer deliveryStatusIdRadio)
  {
    this.deliveryStatusIdRadio = deliveryStatusIdRadio;
  }

  public Integer getColorId()
  {
    return this.colorId;
  }

  public void setColorId(Integer colorId)
  {
    this.colorId = colorId;
  }

  public String getWsAcct()
  {
    return this.wsAcct;
  }

  public void setWsAcct(String wsAcct)
  {
    this.wsAcct = wsAcct;
  }

  public Date getVerifiedDate()
  {
    return this.verifiedDate;
  }

  public void setVerifiedDate(Date verifiedDate)
  {
    this.verifiedDate = verifiedDate;
  }

  public String getVerifiedRemark()
  {
    return this.verifiedRemark;
  }

  public void setVerifiedRemark(String verifiedRemark)
  {
    this.verifiedRemark = verifiedRemark;
  }

  public String getMsisdn()
  {
    return this.msisdn;
  }

  public void setMsisdn(String msisdn)
  {
    this.msisdn = msisdn;
  }

  public String getCreatedByMsisdn()
  {
    return this.createdByMsisdn;
  }

  public void setCreatedByMsisdn(String createdByMsisdn)
  {
    this.createdByMsisdn = createdByMsisdn;
  }

  public String getDateCreatedMsisdn()
  {
    return this.dateCreatedMsisdn;
  }

  public void setDateCreatedMsisdn(String dateCreatedMsisdn)
  {
    this.dateCreatedMsisdn = dateCreatedMsisdn;
  }

  public String getRoleName()
  {
    return this.roleName;
  }

  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }

  public String getOnsiteF()
  {
    return this.onsiteF;
  }

  public void setOnsiteF(String onsiteF)
  {
    this.onsiteF = onsiteF;
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

  public String getDelState()
  {
    return this.delState;
  }

  public void setDelState(String delState)
  {
    this.delState = delState;
  }

  public String getDelPostcode()
  {
    return this.delPostcode;
  }

  public void setDelPostcode(String delPostcode)
  {
    this.delPostcode = delPostcode;
  }

  public String getDelCountry()
  {
    return this.delCountry;
  }

  public void setDelCountry(String delCountry)
  {
    this.delCountry = delCountry;
  }

  public String getMultipleAddress()
  {
    return this.multipleAddress;
  }

  public void setMultipleAddress(String multipleAddress)
  {
    this.multipleAddress = multipleAddress;
  }

  public Integer getTransMsid()
  {
    return this.transMsid;
  }

  public void setTransMsid(Integer transMsid)
  {
    this.transMsid = transMsid;
  }

  public String getCreateRemarks()
  {
    return this.createRemarks;
  }

  public void setCreateRemarks(String createRemarks)
  {
    this.createRemarks = createRemarks;
  }

  public String getRegType()
  {
    return this.regType;
  }

  public void setRegType(String regType)
  {
    this.regType = regType;
  }

  public String getDeliveryAddressButton()
  {
    return this.deliveryAddressButton;
  }

  public void setDeliveryAddressButton(String deliveryAddressButton)
  {
    this.deliveryAddressButton = deliveryAddressButton;
  }

  public String getImei()
  {
    return this.imei;
  }

  public void setImei(String imei)
  {
    this.imei = imei;
  }
}
