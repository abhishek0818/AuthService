package com.example.demo.controller;

import java.security.Principal;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
public class AuthController {
	
	private boolean authenticated = false; 
	private String username;
	
	public boolean isAuthenticated() {
		if(username.length() > 0)
			authenticated = true;
		return authenticated;
	}
	
	@GetMapping("/")
	public String getUserinfo(Principal user) {
		username = user.getName();
		return username;
	}

}
