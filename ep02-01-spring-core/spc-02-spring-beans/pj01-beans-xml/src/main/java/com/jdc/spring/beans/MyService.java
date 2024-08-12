package com.jdc.spring.beans;

public class MyService {
	
	private String message;
	
	public MyService(String message) {
		super();
		this.message = message;
	}

	public String message() {
		return message;
	}
}
