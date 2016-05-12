package in.ankushs.webbrowscap4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ankushs.browscap4j.domain.BrowserCapabilities;
import in.ankushs.webbrowscap4j.service.BrowscapService;

@RestController
@RequestMapping("browscap/lookup")
public class BrowscapController {
	
	//========= ~ Dependencies ~ ==============
	private final BrowscapService browscapService;
	
	@Autowired
	public BrowscapController(final BrowscapService browscapService){
		this.browscapService = browscapService;
	}
	
	//=========================================
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getBrowserCapabilities(@RequestParam(required=true) final String userAgent)
	{
		return new ResponseEntity<BrowserCapabilities>(browscapService.getBrowerCapabilities(userAgent),HttpStatus.OK);
	}
}
