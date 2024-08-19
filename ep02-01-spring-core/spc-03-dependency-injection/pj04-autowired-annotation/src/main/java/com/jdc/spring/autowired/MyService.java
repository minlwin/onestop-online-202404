package com.jdc.spring.autowired;

import org.springframework.stereotype.Component;

@Component
public class MyService {

	public String message() {
		return "Hello from my service.";
	}
}
