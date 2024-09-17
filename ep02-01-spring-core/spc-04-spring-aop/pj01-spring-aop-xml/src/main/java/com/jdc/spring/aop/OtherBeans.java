package com.jdc.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class OtherBeans {

	public void show(String message) {
		// Business Logic
		System.out.println(message);
	}
}
