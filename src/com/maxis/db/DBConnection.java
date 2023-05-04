package com.maxis.db;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.maxis.config.BrightstarSqlConfig;
import java.io.PrintStream;

public class DBConnection
{
  private static SqlMapClient brightStarMapClient = null;

  public static void setDB()
  {
    try
    {
      brightStarMapClient = BrightstarSqlConfig.getSqlMapInstance();
    }
    catch (Exception ex)
    {
      System.out.println("Error in setup " + ex.getMessage());
    }
  }
}