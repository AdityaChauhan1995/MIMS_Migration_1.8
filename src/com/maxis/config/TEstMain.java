package com.maxis.config;

import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.maxis.constant.Constant;
import com.maxis.db.DeviceData;
import com.maxis.db.MaxisEbdPortal;

public class TEstMain {


	public static void main(String args[]){

		try {

			//brightStarMapClient = BrightstarSqlConfig.getSqlMapInstance();
			Reader rd = Resources.getResourceAsReader("com/maxis/config/BrightStarServerConfig.xml");
			SqlMapClient brightStarMapClient = SqlMapClientBuilder.buildSqlMapClient(rd);
			DeviceData deviceData=new DeviceData();
			DeviceData maxisData=new DeviceData();
			maxisData.setOrderNo(1170821);

			deviceData=(DeviceData)brightStarMapClient.queryForObject("select_EbdPortalFlexiFundDevice", maxisData);
			System.out.println(deviceData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
