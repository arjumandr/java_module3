package com.welcome.util;

import org.springframework.stereotype.Component;

@Component
public class MessageGenerator {
	public String generateMessage(String name) {
		return "Hello "+name+", welcome to Spring Boot!";
	}
}
