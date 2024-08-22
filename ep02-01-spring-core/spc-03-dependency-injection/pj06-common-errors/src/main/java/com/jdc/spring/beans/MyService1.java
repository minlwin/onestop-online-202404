package com.jdc.spring.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class MyService1 implements MyService {
	
	private String name;
	
	public MyService1() {
		name = "Service 1";
	}

	@Override
	public String getMessage() {
		return "Hello Spring from %s".formatted(name);
	}
}
