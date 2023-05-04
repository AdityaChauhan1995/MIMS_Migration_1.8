package com.maxis.db;

public class Device
{
  private Integer productId;
  private Integer colorId;
  private Integer deviceId;
  private Integer vendorId;
  private Integer phoneUnitPrice;
  private Integer phoneSubSidyAmount;

  public Integer getVendorId()
  {
    return this.vendorId;
  }

  public void setVendorId(Integer vendorId)
  {
    this.vendorId = vendorId;
  }

  public Integer getProductId()
  {
    return this.productId;
  }

  public void setProductId(Integer productId)
  {
    this.productId = productId;
  }

  public Integer getColorId()
  {
    return this.colorId;
  }

  public void setColorId(Integer colorId)
  {
    this.colorId = colorId;
  }

  public Integer getDeviceId()
  {
    return this.deviceId;
  }

  public void setDeviceId(Integer deviceId)
  {
    this.deviceId = deviceId;
  }

  public Integer getPhoneUnitPrice()
  {
    return this.phoneUnitPrice;
  }

  public void setPhoneUnitPrice(Integer phoneUnitPrice)
  {
    this.phoneUnitPrice = phoneUnitPrice;
  }

  public Integer getPhoneSubSidyAmount()
  {
    return this.phoneSubSidyAmount;
  }

  public void setPhoneSubSidyAmount(Integer phoneSubSidyAmount)
  {
    this.phoneSubSidyAmount = phoneSubSidyAmount;
  }
}
