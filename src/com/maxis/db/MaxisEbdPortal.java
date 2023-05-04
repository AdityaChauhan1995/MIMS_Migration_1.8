package com.maxis.db;

import java.util.Date;

public class MaxisEbdPortal
{
	public Integer regId;
	public Integer custId;
	public String custBrn;
	public Date regDateApproved;
	public String dealerName;
	public String companyName;
	public String custName;
	public String newIc;
	public String billAdd1;
	public String billAdd2;
	public String billAdd3;
	public String billState;
	public String billPostcode;
	public String billCountry;
	public String delAdd1;
	public String delAdd2;
	public String delAdd3;
	public String delState;
	public String delPostcode;
	public String delCountry;
	public String delContactName;
	public String delContactIc;
	public String delContactPhoneNo;
	public String phoneOrderStatus;
	public Integer deviceId;
	public String deviceName;
	public Integer orderNo;
	public String regType;
	public String msisdn;
	public String accountNo;
	public String subscrNo;
	public String createRemarks;
	public String marketType;
	public Integer unitPrice;
	public String imei;
	public String rateplan;
	public Integer rateplanComponentId;
	public Integer rateplanPenaltyComponentId;
	public Integer topupAmount;
	public Integer iTopupAmount;
	public Integer promoId;
	public String onSiteFullfillment;
	public String iddErrMsg;
	public String mimsDeviceId;
	public String mimsColorId;
	public Integer transMsid;
	public Integer del1Length;
	public Integer del2Length;
	public Date mimsSubmitDate;
	public Integer phoneSubsidyAmount;
	public Integer iPhoneSubsidyAmount;
	public Integer deliveryStatusId;
	public Date deliveryDateTime;
	public String verifiedRemark;
	public String extContract;
	public String salesId;
	public String extSalesId;
	public String contactNoFix;
	public Integer bizUnitId;
	public String imeiCompt;
	public Integer count;

	private String status;
	private String remarks;
	private String deviceOrderNo;
	private String virtualServiceNumber;
	
	private Integer easMasterRegId;
	private String primaryContactEmail;
	private String secondaryPicName;
	private String secondaryContactMobileNo;
	private String secondaryPicEmail;
	private String secondaryPicIc;
	private String secondaryContactFixedNo;

	
	
	
	public Integer getEasMasterRegId() {
		return easMasterRegId;
	}

	public void setEasMasterRegId(Integer easMasterRegId) {
		this.easMasterRegId = easMasterRegId;
	}

	public String getSecondaryPicName() {
		return secondaryPicName;
	}

	public void setSecondaryPicName(String secondaryPicName) {
		this.secondaryPicName = secondaryPicName;
	}

	

	public String getPrimaryContactEmail() {
		return primaryContactEmail;
	}

	public void setPrimaryContactEmail(String primaryContactEmail) {
		this.primaryContactEmail = primaryContactEmail;
	}

	public String getSecondaryContactMobileNo() {
		return secondaryContactMobileNo;
	}

	public void setSecondaryContactMobileNo(String secondaryContactMobileNo) {
		this.secondaryContactMobileNo = secondaryContactMobileNo;
	}

	public String getSecondaryContactFixedNo() {
		return secondaryContactFixedNo;
	}

	public void setSecondaryContactFixedNo(String secondaryContactFixedNo) {
		this.secondaryContactFixedNo = secondaryContactFixedNo;
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

	public String getVirtualServiceNumber() {
		return virtualServiceNumber;
	}

	public void setVirtualServiceNumber(String virtualServiceNumber) {
		this.virtualServiceNumber = virtualServiceNumber;
	}

	public String getContactNoFix()
	{
		return this.contactNoFix;
	}

	public void setContactNoFix(String contactNoFix)
	{
		this.contactNoFix = contactNoFix;
	}
	public Integer getiTopupAmount() {
		return iTopupAmount;
	}

	public void setiTopupAmount(Integer iTopupAmount) {
		this.iTopupAmount = iTopupAmount;
	}

	public Integer getiPhoneSubsidyAmount() {
		return iPhoneSubsidyAmount;
	}

	public void setiPhoneSubsidyAmount(Integer iPhoneSubsidyAmount) {
		this.iPhoneSubsidyAmount = iPhoneSubsidyAmount;
	}
	public Integer getBizUnitId()
	{
		return this.bizUnitId;
	}

	public void setBizUnitId(Integer bizUnitId)
	{
		this.bizUnitId = bizUnitId;
	}

	public String getDeviceOrderNo() {
		return deviceOrderNo;
	}

	public void setDeviceOrderNo(String deviceOrderNo) {
		this.deviceOrderNo = deviceOrderNo;
	}


	public String getVerifiedRemark()
	{
		return this.verifiedRemark;
	}

	public void setVerifiedRemark(String verifiedRemark)
	{
		this.verifiedRemark = verifiedRemark;
	}

	public Date getMimsSubmitDate()
	{
		return this.mimsSubmitDate;
	}

	public void setMimsSubmitDate(Date mimsSubmitDate)
	{
		this.mimsSubmitDate = mimsSubmitDate;
	}

	public Integer getRegId()
	{
		return this.regId;
	}

	public void setRegId(Integer regId)
	{
		this.regId = regId;
	}

	public Integer getCustId()
	{
		return this.custId;
	}

	public void setCustId(Integer custId)
	{
		this.custId = custId;
	}

	public String getCustBrn()
	{
		return this.custBrn;
	}

	public void setCustBrn(String custBrn)
	{
		this.custBrn = custBrn;
	}

	public Date getRegDateApproved()
	{
		return this.regDateApproved;
	}

	public void setRegDateApproved(Date regDateApproved)
	{
		this.regDateApproved = regDateApproved;
	}

	public String getDealerName()
	{
		return this.dealerName;
	}

	public void setDealerName(String dealerName)
	{
		this.dealerName = dealerName;
	}

	public String getCompanyName()
	{
		return this.companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getCustName()
	{
		return this.custName;
	}

	public void setCustName(String custName)
	{
		this.custName = custName;
	}

	public String getNewIc()
	{
		return this.newIc;
	}

	public void setNewIc(String newIc)
	{
		this.newIc = newIc;
	}

	public String getBillAdd1()
	{
		return this.billAdd1;
	}

	public void setBillAdd1(String billAdd1)
	{
		this.billAdd1 = billAdd1;
	}

	public String getBillAdd2()
	{
		return this.billAdd2;
	}

	public void setBillAdd2(String billAdd2)
	{
		this.billAdd2 = billAdd2;
	}

	public String getBillAdd3()
	{
		return this.billAdd3;
	}

	public void setBillAdd3(String billAdd3)
	{
		this.billAdd3 = billAdd3;
	}

	public String getBillState()
	{
		return this.billState;
	}

	public void setBillState(String billState)
	{
		this.billState = billState;
	}

	public String getBillPostcode()
	{
		return this.billPostcode;
	}

	public void setBillPostcode(String billPostcode)
	{
		this.billPostcode = billPostcode;
	}

	public String getBillCountry()
	{
		return this.billCountry;
	}

	public void setBillCountry(String billCountry)
	{
		this.billCountry = billCountry;
	}

	public String getDelAdd1()
	{
		return this.delAdd1;
	}

	public void setDelAdd1(String delAdd1)
	{
		this.delAdd1 = delAdd1;
	}

	public String getDelAdd2()
	{
		return this.delAdd2;
	}

	public void setDelAdd2(String delAdd2)
	{
		this.delAdd2 = delAdd2;
	}

	public String getDelAdd3()
	{
		return this.delAdd3;
	}

	public void setDelAdd3(String delAdd3)
	{
		this.delAdd3 = delAdd3;
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

	public String getDelContactName()
	{
		return this.delContactName;
	}

	public void setDelContactName(String delContactName)
	{
		this.delContactName = delContactName;
	}

	public String getDelContactIc()
	{
		return this.delContactIc;
	}

	public void setDelContactIc(String delContactIc)
	{
		this.delContactIc = delContactIc;
	}

	public String getDelContactPhoneNo()
	{
		return this.delContactPhoneNo;
	}

	public void setDelContactPhoneNo(String delContactPhoneNo)
	{
		this.delContactPhoneNo = delContactPhoneNo;
	}

	public String getPhoneOrderStatus()
	{
		return this.phoneOrderStatus;
	}

	public void setPhoneOrderStatus(String phoneOrderStatus)
	{
		this.phoneOrderStatus = phoneOrderStatus;
	}

	public Integer getDeviceId()
	{
		return this.deviceId;
	}

	public void setDeviceId(Integer deviceId)
	{
		this.deviceId = deviceId;
	}

	public String getDeviceName()
	{
		return this.deviceName;
	}

	public void setDeviceName(String deviceName)
	{
		this.deviceName = deviceName;
	}

	public Integer getOrderNo()
	{
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo)
	{
		this.orderNo = orderNo;
	}

	public String getRegType()
	{
		return this.regType;
	}

	public void setRegType(String regType)
	{
		this.regType = regType;
	}

	public String getMsisdn()
	{
		return this.msisdn;
	}

	public void setMsisdn(String msisdn)
	{
		this.msisdn = msisdn;
	}

	public String getAccountNo()
	{
		return this.accountNo;
	}

	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}

	public String getSubscrNo()
	{
		return this.subscrNo;
	}

	public void setSubscrNo(String subscrNo)
	{
		this.subscrNo = subscrNo;
	}

	public String getCreateRemarks()
	{
		return this.createRemarks;
	}

	public void setCreateRemarks(String createRemarks)
	{
		this.createRemarks = createRemarks;
	}

	public String getMarketType()
	{
		return this.marketType;
	}

	public void setMarketType(String marketType)
	{
		this.marketType = marketType;
	}

	public Integer getUnitPrice()
	{
		return this.unitPrice;
	}

	public void setUnitPrice(Integer unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public String getImei()
	{
		return this.imei;
	}

	public void setImei(String imei)
	{
		this.imei = imei;
	}

	public String getRateplan()
	{
		return this.rateplan;
	}

	public void setRateplan(String rateplan)
	{
		this.rateplan = rateplan;
	}

	public Integer getRateplanComponentId()
	{
		return this.rateplanComponentId;
	}

	public void setRateplanComponentId(Integer rateplanComponentId)
	{
		this.rateplanComponentId = rateplanComponentId;
	}

	public Integer getRateplanPenaltyComponentId()
	{
		return this.rateplanPenaltyComponentId;
	}

	public void setRateplanPenaltyComponentId(Integer rateplanPenaltyComponentId)
	{
		this.rateplanPenaltyComponentId = rateplanPenaltyComponentId;
	}

	public Integer getTopupAmount()
	{
		return this.topupAmount;
	}

	public void setTopupAmount(Integer topupAmount)
	{
		this.topupAmount = topupAmount;
	}

	public Integer getPromoId()
	{
		return this.promoId;
	}

	public void setPromoId(Integer promoId)
	{
		this.promoId = promoId;
	}

	public String getOnSiteFullfillment()
	{
		return this.onSiteFullfillment;
	}

	public void setOnSiteFullfillment(String onSiteFullfillment)
	{
		this.onSiteFullfillment = onSiteFullfillment;
	}

	public String getIddErrMsg()
	{
		return this.iddErrMsg;
	}

	public void setIddErrMsg(String iddErrMsg)
	{
		this.iddErrMsg = iddErrMsg;
	}

	public String getMimsDeviceId()
	{
		return this.mimsDeviceId;
	}

	public void setMimsDeviceId(String mimsDeviceId)
	{
		this.mimsDeviceId = mimsDeviceId;
	}

	public String getMimsColorId()
	{
		return this.mimsColorId;
	}

	public void setMimsColorId(String mimsColorId)
	{
		this.mimsColorId = mimsColorId;
	}

	public Integer getTransMsid()
	{
		return this.transMsid;
	}

	public void setTransMsid(Integer transMsid)
	{
		this.transMsid = transMsid;
	}

	public Integer getCount()
	{
		return this.count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public Integer getDel1Length()
	{
		return this.del1Length;
	}

	public void setDel1Length(Integer del1Length)
	{
		this.del1Length = del1Length;
	}

	public Integer getDel2Length()
	{
		return this.del2Length;
	}

	public void setDel2Length(Integer del2Length)
	{
		this.del2Length = del2Length;
	}

	public Integer getPhoneSubsidyAmount()
	{
		return this.phoneSubsidyAmount;
	}

	public void setPhoneSubsidyAmount(Integer phoneSubsidyAmount)
	{
		this.phoneSubsidyAmount = phoneSubsidyAmount;
	}

	public Integer getDeliveryStatusId()
	{
		return this.deliveryStatusId;
	}

	public void setDeliveryStatusId(Integer deliveryStatusId)
	{
		this.deliveryStatusId = deliveryStatusId;
	}

	public Date getDeliveryDateTime()
	{
		return this.deliveryDateTime;
	}

	public void setDeliveryDateTime(Date deliveryDateTime)
	{
		this.deliveryDateTime = deliveryDateTime;
	}

	public String getExtContract()
	{
		return this.extContract;
	}

	public void setExtContract(String extContract)
	{
		this.extContract = extContract;
	}

	public String getSalesId()
	{
		return this.salesId;
	}

	public void setSalesId(String salesId)
	{
		this.salesId = salesId;
	}

	public String getExtSalesId()
	{
		return this.extSalesId;
	}

	public void setExtSalesId(String extSalesId)
	{
		this.extSalesId = extSalesId;
	}

	public String getImeiCompt()
	{
		return this.imeiCompt;
	}

	public void setImeiCompt(String imeiCompt)
	{
		this.imeiCompt = imeiCompt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}