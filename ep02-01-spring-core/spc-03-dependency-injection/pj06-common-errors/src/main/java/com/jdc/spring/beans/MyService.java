package com.jdc.spring.beans;

public class MyService {
	
	private String name;
	
	public MyService(String name) {
		super();
		this.name = name;
	}

	public String getMessage() {
		return "Hello Spring from %s".formatted(name);
	}
}
