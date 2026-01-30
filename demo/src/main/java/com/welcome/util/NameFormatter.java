package com.welcome.util;

import org.springframework.stereotype.Component;

@Component
public class NameFormatter {
	public String formatName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
}
