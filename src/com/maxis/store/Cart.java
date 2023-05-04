package com.maxis.store;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart
{
  private HashMap<Item, Integer> contents;

  public Cart()
  {
    this.contents = new HashMap();
  }

  public void addItem(String itemCode)
  {
    Catalog catalog = new Catalog();
    if (catalog.containsItem(itemCode))
    {
      Item item = catalog.getItem(itemCode);

      int newQuantity = 1;
      if (this.contents.containsKey(item))
      {
        Integer currentQuantity = (Integer)this.contents.get(item);
        newQuantity += currentQuantity.intValue();
      }
      this.contents.put(item, new Integer(newQuantity));
    }
  }

  public void removeItems(String itemCode)
  {
    this.contents.remove(new Catalog().getItem(itemCode));
  }

  public String toXml()
  {
    StringBuffer xml = new StringBuffer();
    xml.append("<?xml version=\"1.0\"?>\n");
    xml.append("<cart generated=\"" + System.currentTimeMillis() + "\" total=\"" + getCartTotal() + "\">\n");
    for (Iterator<Item> I = this.contents.keySet().iterator(); I.hasNext();)
    {
      Item item = (Item)I.next();
      int itemQuantity = ((Integer)this.contents.get(item)).intValue();

      xml.append("<item code=\"" + item.getCode() + "\">\n");
      xml.append("<name>");
      xml.append(item.getName());
      xml.append("</name>\n");
      xml.append("<quantity>");
      xml.append(itemQuantity);
      xml.append("</quantity>\n");
      xml.append("</item>\n");
    }
    xml.append("</cart>\n");
    return xml.toString();
  }

  private String getCartTotal()
  {
    int total = 0;
    for (Iterator<Item> I = this.contents.keySet().iterator(); I.hasNext();)
    {
      Item item = (Item)I.next();
      int itemQuantity = ((Integer)this.contents.get(item)).intValue();

      total += item.getPrice() * itemQuantity;
    }
    return "$" + new BigDecimal(total).movePointLeft(2);
  }
}