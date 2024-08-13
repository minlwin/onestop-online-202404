package com.jdc.online.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	
	public String message() {
		return "Hello from Annotation Base Bean";
	}
}
