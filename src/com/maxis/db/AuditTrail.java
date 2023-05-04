package com.maxis.db;

import java.util.Date;

public class AuditTrail
{
  private Integer auditId;
  private Integer regId;
  private String accessBy;
  private String activity;
  private String remarks;
  private Date auditDate;
  private Integer auditSeqNo;
  private Integer orderNo;

  public Integer getAuditId()
  {
    return this.auditId;
  }

  public void setAuditId(Integer auditId)
  {
    this.auditId = auditId;
  }

  public Integer getRegId()
  {
    return this.regId;
  }

  public void setRegId(Integer regId)
  {
    this.regId = regId;
  }

  public String getAccessBy()
  {
    return this.accessBy;
  }

  public void setAccessBy(String accessBy)
  {
    this.accessBy = accessBy;
  }

  public String getActivity()
  {
    return this.activity;
  }

  public void setActivity(String activity)
  {
    this.activity = activity;
  }

  public String getRemarks()
  {
    return this.remarks;
  }

  public void setRemarks(String remarks)
  {
    this.remarks = remarks;
  }

  public Date getAuditDate()
  {
    return this.auditDate;
  }

  public void setAuditDate(Date auditDate)
  {
    this.auditDate = auditDate;
  }

  public Integer getAuditSeqNo()
  {
    return this.auditSeqNo;
  }

  public void setAuditSeqNo(Integer auditSeqNo)
  {
    this.auditSeqNo = auditSeqNo;
  }

  public Integer getOrderNo()
  {
    return this.orderNo;
  }

  public void setOrderNo(Integer orderNo)
  {
    this.orderNo = orderNo;
  }
}