package com.maxis.config;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.common.resources.Resources;

import java.io.Reader;

/**
 * Created by IntelliJ IDEA.
 * User: OHARIBA
 * Date: 17-Sep-2010
 * Time: 12:59:10
 * To change this template use File | Settings | File Templates.
 */
public class ContractExtSqlConfig {
    private static SqlMapClient sqlMap = null;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("com/maxis/config/ContractExtConfig.xml");
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
        }
        catch (Exception e) {
            // If you get an error at this point, it doesn’t matter what it was. It is going to be
            // unrecoverable and we will want the app to blow up hard so we are aware of the
            // problem. You should always log such errors and re-throw them in such a way that
            // you can be made immediately aware of the problem.
            e.printStackTrace();
            throw new RuntimeException("Error initializing  Cause: " + e);
        }
    }

    public static SqlMapClient getSqlMapInstance() {
        return sqlMap;
    }
}