package com.welcome.service;

import org.springframework.stereotype.Service;

import com.welcome.util.MessageGenerator;
import com.welcome.util.NameFormatter;

@Service
public class WelcomeService {
	private MessageGenerator messageGenerator;
	private NameFormatter nameFormatter;
	
	public WelcomeService(MessageGenerator messageGenerator, NameFormatter nameFormatter) {
		this.messageGenerator = messageGenerator;
		this.nameFormatter = nameFormatter;
	}

	public String greet(String name) {
		String formatterName = nameFormatter.formatName(name);
		return messageGenerator.generateMessage(formatterName);
	}
}
