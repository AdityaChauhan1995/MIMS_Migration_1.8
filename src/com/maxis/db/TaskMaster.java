package com.maxis.db;

public class TaskMaster {
	private String taskId;
	private Integer prodRefGrpMapId;
	private Integer sequenceNo;
	private Integer ownerRoleId;
	private String isTerminal;
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public Integer getProdRefGrpMapId() {
		return prodRefGrpMapId;
	}
	public void setProdRefGrpMapId(Integer prodRefGrpMapId) {
		this.prodRefGrpMapId = prodRefGrpMapId;
	}
	public Integer getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public Integer getOwnerRoleId() {
		return ownerRoleId;
	}
	public void setOwnerRoleId(Integer ownerRoleId) {
		this.ownerRoleId = ownerRoleId;
	}
	public String getIsTerminal() {
		return isTerminal;
	}
	public void setIsTerminal(String isTerminal) {
		this.isTerminal = isTerminal;
	}
}
