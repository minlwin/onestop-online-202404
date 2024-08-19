package com.jdc.spring.autowired;

public class MyClient {

	// Dependency
	private MyService service;
	
	public void setService(MyService service) {
		this.service = service;
	}

	public void showMessage() {
		System.out.printf(service.message());
	}
}
