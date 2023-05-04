package com.maxis.db;



//import java.io.Serializable;
import java.util.Date;

/*import org.springframework.util.ClassUtils;*/

//import com.maxis.common.vo.NewBaseVO;
import com.maxis.db.PortalRegistrationMaster;

public class TransVas {
	
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;*/

	/*public static final String FQN = ClassUtils.getQualifiedName(TransVas.class);*/
	
	private Integer regId;
	private Integer transMsid;
	private Integer vasId;
	private Integer componentId;
	private Integer componentId1;
	private Integer packageId;
	private Integer rateplanId;
	
	private Date dateCreated;
	private String createdBy;	
	private String modifiedBy;
	private Date dateModified;
	
	private Integer regId1;
	private Integer transMsid1;
	
	/*for the sake of rsultset*/
	private String contractType;
	
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	
	public Integer getComponentId1() {
		return componentId1;
	}
	public void setComponentId1(Integer componentId1) {
		this.componentId1 = componentId1;
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
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public Integer getRateplanId() {
		return rateplanId;
	}
	public void setRateplanId(Integer rateplanId) {
		this.rateplanId = rateplanId;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getTransMsid() {
		return transMsid;
	}
	public void setTransMsid(Integer transMsid) {
		this.transMsid = transMsid;
	}
	public Integer getVasId() {
		return vasId;
	}
	public void setVasId(Integer vasId) {
		this.vasId = vasId;
	}
	public Integer getRegId1() {
		return regId1;
	}
	public void setRegId1(Integer regId1) {
		this.regId1 = regId1;
	}
	public Integer getTransMsid1() {
		return transMsid1;
	}
	public void setTransMsid1(Integer transMsid1) {
		this.transMsid1 = transMsid1;
	}
	

		
	

}

