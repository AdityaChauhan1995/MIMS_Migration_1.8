package com.maxis.db;
import java.util.Date;

public class Task {

	  private Integer taskInstanceId;
	  private Integer regId;
	  private Integer transMsid;
	  private String taskId;
	  private String taskIdCompare;
	  public String getTaskIdCompare() {
		return taskIdCompare;
	}
	public void setTaskIdCompare(String taskIdCompare) {
		this.taskIdCompare = taskIdCompare;
	}
	private Integer ownerRoleId;
	  private String createdBy;
	  private Date createdDate ;
	  private String modifiedBy;
	  private Date modifiedDatetime;
	  private String status;
	  private String remarks;
	  private Integer maxInstanceId;
	  private Integer maxInstanceIdSeq;
	public Integer getMaxInstanceIdSeq() {
		return maxInstanceIdSeq;
	}
	public void setMaxInstanceIdSeq(Integer maxInstanceIdSeq) {
		this.maxInstanceIdSeq = maxInstanceIdSeq;
	}
	public Integer getMaxInstanceId() {
		return maxInstanceId;
	}
	public void setMaxInstanceId(Integer maxInstanceId) {
		this.maxInstanceId = maxInstanceId;
	}
	public Integer getTaskInstanceId() {
		return taskInstanceId;
	}
	public void setTaskInstanceId(Integer taskInstanceId) {
		this.taskInstanceId = taskInstanceId;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}


	public Integer getOwnerRoleId() {
		return ownerRoleId;
	}
	public void setOwnerRoleId(Integer ownerRoleId) {
		this.ownerRoleId = ownerRoleId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDatetime() {
		return modifiedDatetime;
	}
	public void setModifiedDatetime(Date modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
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
	public Integer getTransMsid() {
		return transMsid;
	}
	public void setTransMsid(Integer transMsid) {
		this.transMsid = transMsid;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
}
