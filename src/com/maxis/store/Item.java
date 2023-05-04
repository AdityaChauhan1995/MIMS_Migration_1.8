package com.maxis.store;

import java.math.BigDecimal;

public class Item
{
  private String code;
  private String name;
  private String description;
  private int price;

  public Item(String code, String name, String description, int price)
  {
    this.code = code;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public String getCode()
  {
    return this.code;
  }

  public String getName()
  {
    return this.name;
  }

  public String getDescription()
  {
    return this.description;
  }

  public int getPrice()
  {
    return this.price;
  }

  public String getFormattedPrice()
  {
    return "$" + new BigDecimal(this.price).movePointLeft(2);
  }

  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if (this == null) {
      return false;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    return ((Item)o).getCode().equals(this.code);
  }
}