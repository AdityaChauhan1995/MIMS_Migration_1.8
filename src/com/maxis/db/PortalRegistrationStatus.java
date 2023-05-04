package com.maxis.db;

//++UCR20140129002818-START


import java.io.Serializable;
import java.util.Date;



public class PortalRegistrationStatus {

	private static final long serialVersionUID = 255216407558024805L;

	private Integer regStatusId;
	private Integer regStatusSequence;

	public Integer getRegStatusSequence() {
		return regStatusSequence;
	}


	public void setRegStatusSequence(Integer regStatusSequence) {
		this.regStatusSequence = regStatusSequence;
	}


	private Integer regId;

	private String regStatus;

	private String reasonCode;

	private String remarks;
	
	private String externalProductRemarks2;

	private String externalProductStatusId;

	private String externalProductRemarks1;

	private String createUserId;

	private Date dateCreated;
	
	
	private Integer regId1;


	public Integer getRegStatusId() {
		return regStatusId;
	}


	public void setRegStatusId(Integer regStatusId) {
		this.regStatusId = regStatusId;
	}


	public Integer getRegId() {
		return regId;
	}


	public void setRegId(Integer regId) {
		this.regId = regId;
	}


	public String getRegStatus() {
		return regStatus;
	}


	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}


	public String getReasonCode() {
		return reasonCode;
	}


	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getExternalProductStatusId() {
		return externalProductStatusId;
	}


	public void setExternalProductStatusId(String externalProductStatusId) {
		this.externalProductStatusId = externalProductStatusId;
	}


	public String getCreateUserId() {
		return createUserId;
	}


	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Integer getRegId1() {
		return regId1;
	}


	public void setRegId1(Integer regId1) {
		this.regId1 = regId1;
	}


	public String getExternalProductRemarks2() {
		return externalProductRemarks2;
	}


	public void setExternalProductRemarks2(String externalProductRemarks2) {
		this.externalProductRemarks2 = externalProductRemarks2;
	}


	public String getExternalProductRemarks1() {
		return externalProductRemarks1;
	}


	public void setExternalProductRemarks1(String externalProductRemarks1) {
		this.externalProductRemarks1 = externalProductRemarks1;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	


}
