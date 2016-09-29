package in.ankushs.webbrowscap4j.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import in.ankushs.browscap4j.domain.Browscap;
import in.ankushs.webbrowscap4j.config.BrowserCapabilities2;
import in.ankushs.webbrowscap4j.service.BrowscapService;

@Service
public class BrowscapServiceImpl implements BrowscapService {
	
	//========= ~ Dependencies ~ ==============
	private final Browscap browscap;
	
	@Autowired
	public BrowscapServiceImpl(final Browscap browscap){
		this.browscap = browscap;
	}
		
	//=========================================

	@Override
	@Cacheable(cacheNames="browscapCache",key="#userAgent")
	public BrowserCapabilities2 getBrowerCapabilities(final String userAgent) {
		Assert.hasText(userAgent,"No userAgent was provided");
		return new BrowserCapabilities2(browscap.lookup(userAgent));
	}
}
