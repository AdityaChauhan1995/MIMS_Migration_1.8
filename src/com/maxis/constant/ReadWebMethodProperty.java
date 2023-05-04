package com.maxis.constant;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import com.maxis.constant.LogUtil;

public class ReadWebMethodProperty {
	
	private static ReadWebMethodProperty _instance = null;
	private Hashtable<String, String> hashWMCode;
	
	
	private ReadWebMethodProperty() {
		String filename = MessageCode.get(Constant.JRXML_FILE_PATH)+"MaxisEBDWebMethod.properties";
		hashWMCode = new Hashtable<String, String>();
		Properties p = new Properties();
		LogUtil.info(" -----  Web Method Properties File Name ------ " + filename);
		try {
			File f = new File(filename);
		    FileInputStream in = new FileInputStream(f);
			p.load(in);
		} catch (IOException ioe) {
			LogUtil.info("----- Where is the file located ? ------ \n" + filename + " : \n" + ioe.getMessage());
		}

		Enumeration e = p.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = p.getProperty(key);
			hashWMCode.put(key, value);
		}
	}
	
	public static String format(String msgcode, Object[] args) {
		if (_instance == null) {
			_instance = new ReadWebMethodProperty();
		}
		String msg = (String) _instance.hashWMCode.get(msgcode);

		if (msg != null) {
			msg = MessageFormat.format(msg, args);
		}

		return msg;
	}

	public static String get(String msgcode) {
		return ReadWebMethodProperty.format(msgcode, null);
	}

}

