/**
 * 
 */
package com.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.service.HomeService;

/**
 * This class acts as the Controller for Requests & Approvals.
 * 
* @version 1.0
 *
 */
@Controller
@EnableOAuth2Sso
@SessionAttributes("name")
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	private final HomeService homeService;
	
	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/")
	public String welcome(Model model) {
		log.info("Executing HomeController#myRequests()...");
		homeService.getMyRequestsDetails("test");
		return "welcome";

	}

	
}
