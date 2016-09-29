package in.ankushs.webbrowscap4j.service;

import in.ankushs.webbrowscap4j.config.BrowserCapabilities2;

public interface BrowscapService {
	BrowserCapabilities2 getBrowerCapabilities(String userAgent);
}
