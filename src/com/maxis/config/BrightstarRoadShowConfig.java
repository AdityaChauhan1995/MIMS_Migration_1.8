package com.maxis.config;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.common.resources.Resources;

import java.io.Reader;
 
/**
 * Created by IntelliJ IDEA.
 * User: Haribabu
 * Date: 06-May-2010
 * Time: 11:39:31
 * To change this template use File | Settings | File Templates.
 */
public class BrightstarRoadShowConfig  {
private static SqlMapClient sqlMap = null;

static {
    try {
        Reader reader = Resources.getResourceAsReader("com/maxis/config/BrightStarRoadshowServerConfig.xml");
        sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
    }
    catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error initializing BrightstarRoadShowConfig Cause: " + e);
    }
}

    public static SqlMapClient getSqlMapInstance() {
        return sqlMap;
}
}