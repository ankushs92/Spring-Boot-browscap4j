package in.ankushs.webbrowscap4j.service;

import in.ankushs.browscap4j.domain.BrowserCapabilities;

public interface BrowscapService {
	BrowserCapabilities getBrowerCapabilities(String userAgent);
}
