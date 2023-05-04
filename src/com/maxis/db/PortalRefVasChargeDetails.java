package com.maxis.db;



import java.io.Serializable;
//import java.util.Date;

//import com.maxis.db.rateplan.PortalRefRatePlan;
import com.maxis.db.VasRef;



public class PortalRefVasChargeDetails  {
private static final long serialVersionUID = 1L;
private Integer vasId1;
private Integer vasChargeId;
private Integer vasMonthlyAmount;
private Integer chargeTypeValue;
private String annotation;
private Integer installmentDuration;
private Integer monthlyInstallmentAmount;
private String extendedData;
private String deliveryPartner;
private String deviceArticleId;
private String ratePlanBpu;
private String vasName;
private VasRef vasRef;
private Integer basePackagePrice;
/* Pa257018 */
private Integer chargeTypeId;
public VasRef getVasRef() {
return vasRef;
}
public void setVasRef(VasRef vasRef) {
this.vasRef = vasRef;
}
public Integer getChargeTypeValue() {
return chargeTypeValue;
}
public void setChargeTypeValue(Integer chargeTypeValue) {
this.chargeTypeValue = chargeTypeValue;
}
private Integer vasId;
public Integer getVasId() {
return vasId;
}
public void setVasId(Integer vasId) {
this.vasId = vasId;
}
public Integer getVasId1() {
return vasId1;
}
public void setVasId1(Integer vasId1) {
this.vasId1 = vasId1;
}
public Integer getVasChargeId() {
return vasChargeId;
}
public void setVasChargeId(Integer vasChargeId) {
this.vasChargeId = vasChargeId;
}
public Integer getVasMonthlyAmount() {
return vasMonthlyAmount;
}
public void setVasMonthlyAmount(Integer vasMonthlyAmount) {
this.vasMonthlyAmount = vasMonthlyAmount;
}
public String getAnnotation() {
return annotation;
}
public void setAnnotation(String annotation) {
this.annotation = annotation;
}
public Integer getInstallmentDuration() {
return installmentDuration;
}
public void setInstallmentDuration(Integer installmentDuration) {
this.installmentDuration = installmentDuration;
}
public Integer getMonthlyInstallmentAmount() {
return monthlyInstallmentAmount;
}
public void setMonthlyInstallmentAmount(Integer monthlyInstallmentAmount) {
this.monthlyInstallmentAmount = monthlyInstallmentAmount;
}
public String getExtendedData() {
return extendedData;
}
public void setExtendedData(String extendedData) {
this.extendedData = extendedData;
}
public String getDeliveryPartner() {
return deliveryPartner;
}
public void setDeliveryPartner(String deliveryPartner) {
this.deliveryPartner = deliveryPartner;
}
public String getDeviceArticleId() {
return deviceArticleId;
}
public void setDeviceArticleId(String deviceArticleId) {
this.deviceArticleId = deviceArticleId;
}
/**
 * @return the ratePlanBpu
 */
public String getRatePlanBpu() {
	return ratePlanBpu;
}
/**
 * @param ratePlanBpu the ratePlanBpu to set
 */
public void setRatePlanBpu(String ratePlanBpu) {
	this.ratePlanBpu = ratePlanBpu;
}
/**
 * @return the vasName
 */
public String getVasName() {
	return vasName;
}
/**
 * @param vasName the vasName to set
 */
public void setVasName(String vasName) {
	this.vasName = vasName;
}
/**
 * @return the basePackagePrice
 */
public Integer getBasePackagePrice() {
	return basePackagePrice;
}
/**
 * @param basePackagePrice the basePackagePrice to set
 */
public void setBasePackagePrice(Integer basePackagePrice) {
	this.basePackagePrice = basePackagePrice;
}
/**
 * @return the chargeTypeId
 */
public Integer getChargeTypeId() {
	return chargeTypeId;
}
/**
 * @param chargeTypeId the chargeTypeId to set
 */
public void setChargeTypeId(Integer chargeTypeId) {
	this.chargeTypeId = chargeTypeId;
}
}

