package com.tyss.Library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String greetings(HttpServletRequest httpServletRequest) {
		return "Welcome to home page\n"+httpServletRequest.getSession().getId();
	}
}
