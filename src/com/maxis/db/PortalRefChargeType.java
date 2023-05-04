package com.maxis.db;

import java.io.Serializable;
import java.util.Date;
//import java.util.Date;

//import com.maxis.db.rateplan.PortalRefRatePlan;


public class PortalRefChargeType {
	private static final long serialVersionUID = 1L;
	private Integer chargeTypeID;
	private String chargeTypeName;
	private String chargeTypeDescription;
	private Date dateCreated;
	private String createBy;
	private Integer spComponent;
	
	public Integer getChargeTypeID() {
		return chargeTypeID;
	}
	public void setChargeTypeID(Integer chargeTypeID) {
		this.chargeTypeID = chargeTypeID;
	}
	public String getChargeTypeName() {
		return chargeTypeName;
	}
	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}
	public String getChargeTypeDescription() {
		return chargeTypeDescription;
	}
	public void setChargeTypeDescription(String chargeTypeDescription) {
		this.chargeTypeDescription = chargeTypeDescription;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Integer getSpComponent() {
		return spComponent;
	}
	public void setSpComponent(Integer spComponent) {
		this.spComponent = spComponent;
	}
	
}

