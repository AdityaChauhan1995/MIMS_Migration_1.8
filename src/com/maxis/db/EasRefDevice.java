package com.maxis.db;



import java.io.Serializable;
import java.util.Date;





public class EasRefDevice{
	
private static final long serialVersionUID = 1L;
	
	
	
	private Integer Id;
	private Integer deviceId;
	private String deviceName;
	private Integer monthlyInstallment;
	private Float upgradeFee;
	private Integer noOfInstallments;
	private Float monthlyReducingBalance;
	private Integer easPackageId;
	private Integer deviceRrp;
	private Integer deviceRRPAmount;
	private Double deviceRRp;
	private Date deliveryDate;
	private String deliveryDateFinal;
	private Integer brandId;
	private Integer delIndex;
	private Integer vendorId;
	private Integer quantity;
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getDeliveryDateFinal() {
		return deliveryDateFinal;
	}
	public void setDeliveryDateFinal(String deliveryDateFinal) {
		this.deliveryDateFinal = deliveryDateFinal;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Double getDeviceRRp() {
		return deviceRRp;
	}
	public void setDeviceRRp(Double deviceRRp) {
		this.deviceRRp = deviceRRp;
	}
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDeviceRrp() {
		return deviceRrp;
	}
	public void setDeviceRrp(Integer deviceRrp) {
		this.deviceRrp = deviceRrp;
	}
	private String deviceArticleId;
	private String deviceArticleId1;
	public String getDeviceArticleId1() {
		return deviceArticleId1;
	}
	public void setDeviceArticleId1(String deviceArticleId1) {
		this.deviceArticleId1 = deviceArticleId1;
	}
	private String deviceUom;
	private String deviceBinId;
	private Integer configId;
	private String parameterValue;
	private String parameterValue1;
	private Date startDate;
	private Date expiryDate;
	private Float zerolutionUpgrade;
	private Float zerolutionPremium;
	private String IMEI;
	private String  kenanDeviceName;
	private Float discountRef;
	private Float kenanRRP;
    
	/*++Device_Finance++*/
	private String msisdn;
	private Integer count;
	private String source;
	private String deliveryPartner;
	
	public String getDeliveryPartner() {
		return deliveryPartner;
	}
	public void setDeliveryPartner(String deliveryPartner) {
		this.deliveryPartner = deliveryPartner;
	}
	public String getKenanDeviceName() {
		return kenanDeviceName;
	}
	public void setKenanDeviceName(String kenanDeviceName) {
		this.kenanDeviceName = kenanDeviceName;
	}
	public Float getDiscountRef() {
		return discountRef;
	}
	public void setDiscountRef(Float discountRef) {
		this.discountRef = discountRef;
	}
	public Float getKenanRRP() {
		return kenanRRP;
	}
	public void setKenanRRP(Float kenanRRP) {
		this.kenanRRP = kenanRRP;
	}
	/*The below for Resultset*/
	private Integer orderNo;
	private Integer phoneUnitPrice;
	private Integer transMsid;
	private String delAddr1;
	private String delAddr2;
	private String delAddr3;
	private String delState;
	private String delPostcode;
	private String delCountry;
	private String easDeviceModel;
	private String deviceOrderNo;
	private String fsOrderNo;

	private Integer deviceCount;
	private String remainingBalWaiverComp;


	
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getPhoneUnitPrice() {
		return phoneUnitPrice;
	}
	public void setPhoneUnitPrice(Integer phoneUnitPrice) {
		this.phoneUnitPrice = phoneUnitPrice;
	}
	public Integer getTransMsid() {
		return transMsid;
	}
	public void setTransMsid(Integer transMsid) {
		this.transMsid = transMsid;
	}
	public String getDelAddr1() {
		return delAddr1;
	}
	public void setDelAddr1(String delAddr1) {
		this.delAddr1 = delAddr1;
	}
	public String getDelAddr2() {
		return delAddr2;
	}
	public void setDelAddr2(String delAddr2) {
		this.delAddr2 = delAddr2;
	}
	public String getDelAddr3() {
		return delAddr3;
	}
	public void setDelAddr3(String delAddr3) {
		this.delAddr3 = delAddr3;
	}
	public String getDelState() {
		return delState;
	}
	public void setDelState(String delState) {
		this.delState = delState;
	}
	public String getDelPostcode() {
		return delPostcode;
	}
	public void setDelPostcode(String delPostcode) {
		this.delPostcode = delPostcode;
	}
	public String getDelCountry() {
		return delCountry;
	}
	public void setDelCountry(String delCountry) {
		this.delCountry = delCountry;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Integer getMonthlyInstallment() {
		//if(monthlyInstallment == null) monthlyInstallment = 0f;
		return monthlyInstallment;
	}
	public void setMonthlyInstallment(Integer monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}
	public Float getUpgradeFee() {
		if(upgradeFee==null) upgradeFee=0f;
		return upgradeFee;
	}
	public void setUpgradeFee(Float upgradeFee) {
		this.upgradeFee = upgradeFee;
	}
	public Integer getNoOfInstallments() {
		return noOfInstallments;
	}
	public void setNoOfInstallments(Integer noOfInstallments) {
		this.noOfInstallments = noOfInstallments;
	}
	public Float getMonthlyReducingBalance() {
		return monthlyReducingBalance;
	}
	public void setMonthlyReducingBalance(Float monthlyReducingBalance) {
		this.monthlyReducingBalance = monthlyReducingBalance;
	}
	public Integer getEasPackageId() {
		return easPackageId;
	}
	public void setEasPackageId(Integer easPackageId) {
		this.easPackageId = easPackageId;
	}

	public String getDeviceArticleId() {
		return deviceArticleId;
	}
	public void setDeviceArticleId(String deviceArticleId) {
		this.deviceArticleId = deviceArticleId;
	}
	public String getDeviceUom() {
		return deviceUom;
	}
	public void setDeviceUom(String deviceUom) {
		this.deviceUom = deviceUom;
	}
	public String getDeviceBinId() {
		return deviceBinId;
	}
	public void setDeviceBinId(String deviceBinId) {
		this.deviceBinId = deviceBinId;
	}
	public Integer getConfigId() {
		return configId;
	}
	public void setConfigId(Integer configId) {
		this.configId = configId;
	}
	public String getParameterValue() {
		return parameterValue;
	}
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getParameterValue1() {
		return parameterValue1;
	}
	public void setParameterValue1(String parameterValue1) {
		this.parameterValue1 = parameterValue1;
	}
	public String getEasDeviceModel() {
		return easDeviceModel;
	}
	public void setEasDeviceModel(String easDeviceModel) {
		this.easDeviceModel = easDeviceModel;
	}
	public Float getZerolutionUpgrade() {
		if(zerolutionUpgrade ==null) zerolutionUpgrade = 0.0f;
		return zerolutionUpgrade;
	}
	public void setZerolutionUpgrade(Float zerolutionUpgrade) {
		this.zerolutionUpgrade = zerolutionUpgrade;
	}
	public Float getZerolutionPremium() {
		return zerolutionPremium;
	}
	public void setZerolutionPremium(Float zerolutionPremium) {
		this.zerolutionPremium = zerolutionPremium;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	
	/*++Device_Finance++*/

	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	private Integer groupId;
	private String penaltyComponent;
	private String installmentComponent;
	private String upgradeComponent;
	private String premiumProtectionComponent;
	private String mdpComponent;
    private Float safeDeviceMnthlyChrg;
    private Float zerltionSafeDeviceMnthlyChrg;
    private String zerltionSafeDeviceComponent;
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getPenaltyComponent() {
		return penaltyComponent;
	}
	public void setPenaltyComponent(String penaltyComponent) {
		this.penaltyComponent = penaltyComponent;
	}
	public String getInstallmentComponent() {
		return installmentComponent;
	}
	public void setInstallmentComponent(String installmentComponent) {
		this.installmentComponent = installmentComponent;
	}
	public String getUpgradeComponent() {
		return upgradeComponent;
	}
	public void setUpgradeComponent(String upgradeComponent) {
		this.upgradeComponent = upgradeComponent;
	}
	public String getPremiumProtectionComponent() {
		return premiumProtectionComponent;
	}
	public void setPremiumProtectionComponent(String premiumProtectionComponent) {
		this.premiumProtectionComponent = premiumProtectionComponent;
	}
	public String getMdpComponent() {
		return mdpComponent;
	}
	public void setMdpComponent(String mdpComponent) {
		this.mdpComponent = mdpComponent;
	}
	
	@Override
	public boolean equals(Object arg0) {
		
		String foreignToken =  ((EasRefDevice) arg0).getPenaltyComponent() ;
		String selfToken = this.getPenaltyComponent();
		
		if( selfToken.equalsIgnoreCase(foreignToken) ){
			return true;
		}
		return false;
	};
	@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Integer.valueOf(this.getPenaltyComponent().split(":")[0]).intValue();
			//return super.hashCode();
		}
	public Float getSafeDeviceMnthlyChrg() {
		//return safeDeviceMnthlyChrg;
		if(safeDeviceMnthlyChrg==null) safeDeviceMnthlyChrg=0f;
		return safeDeviceMnthlyChrg;
	}
	public void setSafeDeviceMnthlyChrg(Float safeDeviceMnthlyChrg) {
		this.safeDeviceMnthlyChrg = safeDeviceMnthlyChrg;
	}
	public Float getZerltionSafeDeviceMnthlyChrg() {
		//return zerltionSafeDeviceMnthlyChrg;
		if(zerltionSafeDeviceMnthlyChrg==null) zerltionSafeDeviceMnthlyChrg=0f;
		return zerltionSafeDeviceMnthlyChrg;
	}
	public void setZerltionSafeDeviceMnthlyChrg(Float zerltionSafeDeviceMnthlyChrg) {
		this.zerltionSafeDeviceMnthlyChrg = zerltionSafeDeviceMnthlyChrg;
	}
	public String getZerltionSafeDeviceComponent() {
		return zerltionSafeDeviceComponent;
	}
	public void setZerltionSafeDeviceComponent(String zerltionSafeDeviceComponent) {
		this.zerltionSafeDeviceComponent = zerltionSafeDeviceComponent;
	}
	
private String zerolutionComponent;
public String getZerolutionComponent() {
	return zerolutionComponent;
}
public void setZerolutionComponent(String zerolutionComponent) {
	this.zerolutionComponent = zerolutionComponent;
}
/**
 * @return the deviceOrderNo
 */
public String getDeviceOrderNo() {
	return deviceOrderNo;
}
/**
 * @param deviceOrderNo the deviceOrderNo to set
 */
public void setDeviceOrderNo(String deviceOrderNo) {
	this.deviceOrderNo = deviceOrderNo;
}
/**
 * @return the fsOrderNo
 */
public String getFsOrderNo() {
	return fsOrderNo;
}
/**
 * @param fsOrderNo the fsOrderNo to set
 */
public void setFsOrderNo(String fsOrderNo) {
	this.fsOrderNo = fsOrderNo;
}
public String getRemainingBalWaiverComp() {
	return remainingBalWaiverComp;
}
public void setRemainingBalWaiverComp(String remainingBalWaiverComp) {
	this.remainingBalWaiverComp = remainingBalWaiverComp;
}
public Integer getDelIndex() {
	return delIndex;
}
public void setDelIndex(Integer delIndex) {
	this.delIndex = delIndex;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public Integer getVendorId() {
	return vendorId;
}
public void setVendorId(Integer vendorId) {
	this.vendorId = vendorId;
}
public Integer getDeviceRRPAmount() {
	return deviceRRPAmount;
}
public void setDeviceRRPAmount(Integer deviceRRPAmount) {
	this.deviceRRPAmount = deviceRRPAmount;
}

	
	
	
}

