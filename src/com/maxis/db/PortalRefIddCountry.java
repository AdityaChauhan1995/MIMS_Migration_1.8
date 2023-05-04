package com.maxis.db;



import java.io.Serializable;



public class PortalRefIddCountry{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country;
	private Integer corridorPlanId;
	private String shortDisplay;
	private Integer point;
	private Integer transMsid;
	public Integer getTransMsid() {
		return transMsid;
	}
	public void setTransMsid(Integer transMsid) {
		this.transMsid = transMsid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getCorridorPlanId() {
		return corridorPlanId;
	}
	public void setCorridorPlanId(Integer corridorPlanId) {
		this.corridorPlanId = corridorPlanId;
	}
	public String getShortDisplay() {
		return shortDisplay;
	}
	public void setShortDisplay(String shortDisplay) {
		this.shortDisplay = shortDisplay;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	
	
}

