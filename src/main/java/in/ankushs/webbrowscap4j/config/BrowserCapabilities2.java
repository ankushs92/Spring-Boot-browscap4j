package in.ankushs.webbrowscap4j.config;

import in.ankushs.browscap4j.domain.BrowserCapabilities;

public class BrowserCapabilities2 {
	private  String browser;
	private  String deviceName;
	private  String deviceType;

	private  String deviceCodeName;
	private  String deviceBrandName;
	private  String platform;
	private  String platformMaker;
	private  String platformVersion;
	private  boolean isMobile;
	private  boolean isTablet;
	
	public BrowserCapabilities2(){}
	
	public BrowserCapabilities2(BrowserCapabilities browserCapabilities){
		this.browser = browserCapabilities.getBrowser();
		this.deviceBrandName = browserCapabilities.getDeviceBrandName();
		this.deviceCodeName = browserCapabilities.getDeviceCodeName();
		this.deviceName = browserCapabilities.getDeviceName();
		this.deviceType = browserCapabilities.getDeviceType();
		this.platform = browserCapabilities.getPlatform();
		this.platformMaker = browserCapabilities.getPlatformMaker();
		this.platformVersion = browserCapabilities.getPlatformVersion();
		this.isMobile = browserCapabilities.isMobile();
		this.isTablet = browserCapabilities.isTablet();
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceCodeName() {
		return deviceCodeName;
	}

	public void setDeviceCodeName(String deviceCodeName) {
		this.deviceCodeName = deviceCodeName;
	}

	public String getDeviceBrandName() {
		return deviceBrandName;
	}

	public void setDeviceBrandName(String deviceBrandName) {
		this.deviceBrandName = deviceBrandName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatformMaker() {
		return platformMaker;
	}

	public void setPlatformMaker(String platformMaker) {
		this.platformMaker = platformMaker;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public boolean isMobile() {
		return isMobile;
	}

	public void setMobile(boolean isMobile) {
		this.isMobile = isMobile;
	}

	public boolean isTablet() {
		return isTablet;
	}

	public void setTablet(boolean isTablet) {
		this.isTablet = isTablet;
	}

}
