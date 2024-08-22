package com.jdc.spring.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyService3 implements MyService {
	
	private String name;
	
	public MyService3() {
		name = "Service 3";
	}

	@Override
	public String getMessage() {
		return "Hello Spring from %s".formatted(name);
	}
}
