package com.jdc.spring.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MyService2 implements MyService {
	
	private String name;
	
	public MyService2() {
		name = "Service 2";
	}

	@Override
	public String getMessage() {
		return "Hello Spring from %s".formatted(name);
	}
}
