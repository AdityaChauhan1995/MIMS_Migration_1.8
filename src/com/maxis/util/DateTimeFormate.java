package com.maxis.util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormate
{
  public static void main(String[] args)
  {
    String pattern = "MM/dd/yyyy hh:mm:ss";
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    Date date = null;
    Date dateCreated = new Date(System.currentTimeMillis());
    try
    {
      date = format.parse("12/30/2010 1:00:00 PM");
      System.out.println(format.format(date));
      System.out.println(date);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    System.out.println(dateCreated);
    System.out.println(date);
  }
}
