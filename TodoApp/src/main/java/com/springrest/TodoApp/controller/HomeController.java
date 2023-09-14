package com.springrest.TodoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HomeController {
	
	private AuthenticationService authenticationService;
	
	public HomeController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String welcome(@RequestParam String name, 
			@RequestParam String password , ModelMap map) {
		
		if(authenticationService.authenticate(name, password)) {
			
		
		map.put("name", name);
		return "welcome";
		}
		else {
			map.put("errorMessage", "Invalid Credential! Please Try Again");
			return "login";
		}
	}
}
