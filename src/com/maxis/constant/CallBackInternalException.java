package com.maxis.constant;

public class CallBackInternalException extends Exception{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String exceptionIndicator;
private String exceptionMessage;
public String getExceptionIndicator() {
	return exceptionIndicator;
}
public void setExceptionIndicator(String exceptionIndicator) {
	this.exceptionIndicator = exceptionIndicator;
}
public String getExceptionMessage() {
	return exceptionMessage;
}
public void setExceptionMessage(String exceptionMessage) {
	this.exceptionMessage = exceptionMessage;
}

}
