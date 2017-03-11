package com.utkcorp.carzonline.client.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarzOnlineFacade {

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String getLoginPage() {
		return "basic/login";
	}
	
	@RequestMapping(path = "/loginFailure", method = RequestMethod.POST)
	public String getLoginFailurePage() {
		return "redirect:login";
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public String getLogoutPage() {
		return "basic/logout";
	}
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@RequestMapping(path = "/homepage", method = RequestMethod.POST)
	public String getHomepage() {
		return "basic/homepage";
	}
	
	@RequestMapping(path = "/serviceDenied", method = RequestMethod.POST)
	public String getServiceDeniedPage() {
		return "basic/serviceDenied";
	}

}
