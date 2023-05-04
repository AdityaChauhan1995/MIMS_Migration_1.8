package com.maxis.db;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class GlobalConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer iParamID;
	private String strParameterName;
	private String strParameterValue;
	private Date dtCreatedDate;
	private String strCreatedBy;
	private Date dtModifiedDate;
	private String strModifiedBy;
	public Integer getiParamID() {
		return iParamID;
	}
	public void setiParamID(Integer iParamID) {
		this.iParamID = iParamID;
	}
	public String getStrParameterName() {
		return strParameterName;
	}
	public void setStrParameterName(String strParameterName) {
		this.strParameterName = strParameterName;
	}
	
	public Date getDtCreatedDate() {
		return dtCreatedDate;
	}
	public void setDtCreatedDate(Date dtCreatedDate) {
		this.dtCreatedDate = dtCreatedDate;
	}
	public String getStrCreatedBy() {
		return strCreatedBy;
	}
	public void setStrCreatedBy(String strCreatedBy) {
		this.strCreatedBy = strCreatedBy;
	}
	public Date getDtModifiedDate() {
		return dtModifiedDate;
	}
	public void setDtModifiedDate(Date dtModifiedDate) {
		this.dtModifiedDate = dtModifiedDate;
	}
	public String getStrModifiedBy() {
		return strModifiedBy;
	}
	public void setStrModifiedBy(String strModifiedBy) {
		this.strModifiedBy = strModifiedBy;
	}
	public String getStrParameterValue() {
		return strParameterValue;
	}
	public void setStrParameterValue(String strParameterValue) {
		this.strParameterValue = strParameterValue;
	}
}