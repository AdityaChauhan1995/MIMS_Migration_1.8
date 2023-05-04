package com.maxis.db;



//import java.io.Serializable;
import java.util.Date;

//import com.maxis.common.vo.NewBaseVO;

public class Dealer  {

    private static final long serialVersionUID = 1L;
    
    private String dealerCode;    
    private String dealerCode1;
    private String userId;
    private String userName;
    private Integer salesChannelId;
    private String dealerName;    
    private String createdBy;	
	private String modifiedBy;	
	private Date dateCreated;	
	private Date dateModified;		
	private String dealerName1;	 
	private String userName1;	 
	private String dealerCodeName;
	private String dealerNameCode;
	
	public String getDealerCodeName() {
		return dealerCodeName;
	}

	public void setDealerCodeName(String dealerCodeName) {
		this.dealerCodeName = dealerCodeName;
	}

	public String getDealerNameCode() {
		return dealerNameCode;
	}

	public void setDealerNameCode(String dealerNameCode) {
		this.dealerNameCode = dealerNameCode;
	}

	public String getDealerName1() {
		return dealerName1;
	}

	public void setDealerName1(String dealerName1) {
		this.dealerName1 = dealerName1;
	}

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

	public String getDealerCode1() {
		return dealerCode1;
	}

	public void setDealerCode1(String dealerCode1) {
		this.dealerCode1 = dealerCode1;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Integer getSalesChannelId() {
		return salesChannelId;
	}

	public void setSalesChannelId(Integer salesChannelId) {
		this.salesChannelId = salesChannelId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

}

