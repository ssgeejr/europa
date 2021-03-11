package com.eightonefournorth.europa.client;

public class UserAgentItem {

	private String clientOS = "unknown";
	private String browserName = "unknown";
	private String browserVer = "unknown";
	
	public String getClientOS() {
		return clientOS;
	}
	public void setClientOS(String clientOS) {
		this.clientOS = clientOS;
	}
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getBrowserVer() {
		return browserVer;
	}
	public void setBrowserVer(String browserVer) {
		this.browserVer = browserVer;
	}
	
	public String toString() {
		return "clientOS [" + clientOS + "] browserName [" + browserName + "] browserVer [" + browserVer + "]";
		
	}
	
}
