package com.maxis.constant;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.text.MessageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class MessageCode {
	private Logger logger = Logger.getLogger(MessageCode.class.getName());
	private MessageCode() {
		String filename = "MessageCode.properties";
		hashMsgCode = new Hashtable<String, String>();
		Properties p = new Properties();
		//loading from current directory of this class
		InputStream is = getClass().getResourceAsStream(filename);
		try {
			p.load(is);
		} catch (IOException ioe) {
			logger.warning("Could not load " + filename + ": " + ioe.getMessage());
		}

		Enumeration e = p.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = p.getProperty(key);
			hashMsgCode.put(key, value);
		}
	}

	public static void main(String[] args) {
		Object[] objs = new Object[] { "HARI", "BABU" };
		LogUtil.info(MessageCode.format("ERR_MSG_014", objs));
		LogUtil.info(MessageCode.get("ERR_MSG_002"));
	}
	private static MessageCode _instance = null;
	public static final String RETURN_MSG = "returnmsg";
	private Hashtable<String, String> hashMsgCode;
	public static String format(String msgcode, Object[] args) {
		if (_instance == null) {
			_instance = new MessageCode();
		}
		String msg = (String) _instance.hashMsgCode.get(msgcode);

		if (msg != null) {
			msg = MessageFormat.format(msg, args);
		}

		return msg;
	}

	public static String get(String msgcode) {
		String strMessage="";
		
		if(msgcode.startsWith("WEBMETHOD")) {
			strMessage = ReadWebMethodProperty.get(msgcode);
		} else {
			strMessage = MessageCode.format(msgcode, null);
		}
		return strMessage;
	}

}
