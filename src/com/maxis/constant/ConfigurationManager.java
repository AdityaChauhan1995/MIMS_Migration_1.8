package com.maxis.constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigurationManager {

	Log log = LogFactory.getLog(this.getClass());


	public Hashtable<String, String> readConfig() {


		String filename = "E:\\config\\config.properties";

		Hashtable<String, String> hashMsgCode = new Hashtable<String, String>();
		Properties p = new Properties();	    
		log.info(" ----- File Name ------ " + filename);
		try {
			File f = new File(filename);
			FileInputStream in = new FileInputStream(f);
			p.load(in);
		}catch (IOException ioe){
			log.info(" ----- Where is the file located ? ------ \n" + filename + " : \n" + ioe.getMessage());
		}

		Enumeration e = p.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = (String) p.getProperty(key);
			hashMsgCode.put(key, value);
		}

		return hashMsgCode;
	}

}
