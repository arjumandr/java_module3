package com.welcome.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.service.WelcomeService;

@RestController
@RequestMapping("/api")
public class WelcomeController {
	private final WelcomeService welcomeService;

	public WelcomeController(WelcomeService welcomeService) {
		this.welcomeService = welcomeService;
	}
	
	@GetMapping("/welcome/{name}")
	public String greet(@PathVariable String name) {
		return welcomeService.greet(name);
	}
	
	@GetMapping("welcome/health")
	public Map<String, String	> health() {
		Map<String, String> response = new HashMap<>();
		response.put("status", "Up");
		response.put("application", "Welcome App");
		response.put("Author", "Arjumand Rashid");
		return response;
	}
	
}
