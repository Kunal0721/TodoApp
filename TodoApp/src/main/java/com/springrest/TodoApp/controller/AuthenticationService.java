package com.springrest.TodoApp.controller;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("kunal");
		boolean isValidPassword = password.equalsIgnoreCase("asdf");
		
		return isValidUserName && isValidPassword;
	}
}
