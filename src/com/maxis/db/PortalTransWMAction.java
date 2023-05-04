package com.maxis.db;


import java.io.Serializable;
import java.util.Date;


/*import org.springframework.util.ClassUtils;*/

/*import com.maxis.constant.NewBaseVO;*/

/*import com.maxis.common.vo.NewBaseVO;
import com.maxis.db.vas.TransMsisdn;*/

/*public class PortalTransWMAction  extends NewBaseVO implements Serializable{*/
public class PortalTransWMAction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*public static final String FQN = ClassUtils.getQualifiedName(PortalTransWMAction.class);*/
	private String wmOrderId;
	private Integer regId;
	//private Integer TransMsid;
	private Integer easMasterRegId;
	private String wmActionStatusCode;
	private String wmStatus;
	private String wmStatusMsg;
	private Integer retryCount;
	private Date wmTriggerTime;
	private Integer regTypeId;
	private String wmActionName;
	private String ackStatusId;
	private String channelId;
	private Date dateCreated;
	private Date dateModified;
	private Integer orderNo;
	private Integer transMsid;
	
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	private String memberTransferIndicatorForStatus;
	private String regType;
	
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getWmOrderId() {
		return wmOrderId;
	}
	public void setWmOrderId(String wmOrderId) {
		this.wmOrderId = wmOrderId;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	/*public Integer getTransMsid() {
		return TransMsid;
	}
	public void setTransMsid(Integer transMsid) {
		TransMsid = transMsid;
	}*/
	public Integer getEasMasterRegId() {
		return easMasterRegId;
	}
	public Integer getTransMsid() {
		return transMsid;
	}
	public void setTransMsid(Integer transMsid) {
		this.transMsid = transMsid;
	}
	public void setEasMasterRegId(Integer easMasterRegId) {
		this.easMasterRegId = easMasterRegId;
	}
	public String getWmActionStatusCode() {
		return wmActionStatusCode;
	}
	public void setWmActionStatusCode(String wmActionStatusCode) {
		this.wmActionStatusCode = wmActionStatusCode;
	}
	public String getWmStatus() {
		return wmStatus;
	}
	public void setWmStatus(String wmStatus) {
		this.wmStatus = wmStatus;
	}
	public String getWmStatusMsg() {
		return wmStatusMsg;
	}
	public void setWmStatusMsg(String wmStatusMsg) {
		this.wmStatusMsg = wmStatusMsg;
	}
	public Integer getRetryCount() {
		return retryCount;
	}
	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
	public Date getWmTriggerTime() {
		return wmTriggerTime;
	}
	public void setWmTriggerTime(Date wmTriggerTime) {
		this.wmTriggerTime = wmTriggerTime;
	}
	public Integer getRegTypeId() {
		return regTypeId;
	}
	public void setRegTypeId(Integer regTypeId) {
		this.regTypeId = regTypeId;
	}
	public String getWmActionName() {
		return wmActionName;
	}
	public void setWmActionName(String wmActionName) {
		this.wmActionName = wmActionName;
	}
	public String getAckStatusId() {
		return ackStatusId;
	}
	public void setAckStatusId(String ackStatusId) {
		this.ackStatusId = ackStatusId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getMemberTransferIndicatorForStatus() {
		return memberTransferIndicatorForStatus;
	}
	public void setMemberTransferIndicatorForStatus(
			String memberTransferIndicatorForStatus) {
		this.memberTransferIndicatorForStatus = memberTransferIndicatorForStatus;
	}
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	
}

