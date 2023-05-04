package com.maxis.db;



import java.io.Serializable;



public class AcctMgrRef {

    private static final long serialVersionUID = 1L;

	
	private Integer acctMgrId;
	
	private String acctMgrName;
	
	private String acctMgrMobile;
	
	private String acctMgrEmail;
	
	private Integer industryId;
	
	private String dealerCode;
	
	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getAcctMgrEmail() {
		return acctMgrEmail;
	}

	public void setAcctMgrEmail(String acctMgrEmail) {
		this.acctMgrEmail = acctMgrEmail;
	}

	public String getAcctMgrMobile() {
		return acctMgrMobile;
	}

	public void setAcctMgrMobile(String acctMgrMobile) {
		this.acctMgrMobile = acctMgrMobile;
	}

	public String getAcctMgrName() {
		return acctMgrName;
	}

	public void setAcctMgrName(String acctMgrName) {
		this.acctMgrName = acctMgrName;
	}

	public Integer getAcctMgrId() {
		return acctMgrId;
	}

	public void setAcctMgrId(Integer acctMgrId) {
		this.acctMgrId = acctMgrId;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	
	
	
	
}

