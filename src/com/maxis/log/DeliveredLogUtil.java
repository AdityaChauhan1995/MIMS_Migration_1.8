package com.maxis.log;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeliveredLogUtil
{
  public static void info(String Message)
  {
    String strdate = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
    String logfilename = null;
    strdate = dateFormat1.format(new Date());


     String logfilepath = "D:/log/";
   /* String logfilepath = "E:/log/";*/

    logfilename = "DeliveredServletPROD.log";


    logfilename = replace(logfilename, ".", "_" + strdate + ".");
    if ((logfilepath != null) && (logfilename != null))
    {
      File myFile = null;
      PrintWriter out = null;

      myFile = new File(logfilepath + logfilename);
      String dateVal = null;
      if (myFile != null)
      {
        if (!myFile.isDirectory()) {
          try
          {
            FileWriter myWriter = new FileWriter(logfilepath + logfilename, true);

            out = new PrintWriter(myWriter);
            out.println(dateFormat.format(new Date()) + ";" + Message);
            out.close();
            myWriter.close();
          }
          catch (Exception e)
          {
            System.out.println("Write File Error " + e.getMessage());
          }
        }
        myFile = null;
      }
    }
    else
    {
      System.out.println(dateFormat.format(new Date()) + " : ");
    }
  }

  public static String replace(String oriStr, String oldStr, String newStr)
  {
    if (oriStr == null) {
      return null;
    }
    int start = oriStr.indexOf(oldStr);
    if (start == -1) {
      return oriStr;
    }
    int oldLen = oldStr.length();

    char[] origChars = oriStr.toCharArray();

    StringBuffer buffer = new StringBuffer();

    int copyFrom = 0;
    while (start != -1)
    {
      buffer.append(origChars, copyFrom, start - copyFrom);
      buffer.append(newStr);
      copyFrom = start + oldLen;
      start = oriStr.indexOf(oldStr, copyFrom);
    }
    buffer.append(origChars, copyFrom, origChars.length - copyFrom);

    return buffer.toString();
  }
}
