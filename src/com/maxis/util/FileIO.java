package com.maxis.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileIO
{
  public static void main(String[] args)
  {
    ArrayList bob = loadFile("D:\\Templ\\mims_WMB.txt");
    for (int i = 0; i < bob.size(); i++) {
      System.out.println("Line No " + (i + 1) + ":\t" + bob.get(i));
    }
  }

  public static ArrayList loadFile(String fileName)
  {
    if ((fileName == null) || (fileName == "")) {
      throw new IllegalArgumentException();
    }
    ArrayList list = new ArrayList();
    try
    {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      if (!in.ready()) {
        throw new IOException();
      }
      String line;
      while ((line = in.readLine()) != null) {
        list.add(line);
      }
      in.close();
    }
    catch (IOException e)
    {
      System.out.println(e);
      return null;
    }
    return list;
  }
}
