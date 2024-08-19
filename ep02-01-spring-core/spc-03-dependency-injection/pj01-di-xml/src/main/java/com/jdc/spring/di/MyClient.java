package com.jdc.spring.di;

public class MyClient {

	// Dependency
	private MyService service;
	private String name;
	
	public MyClient() {
	}
	
	public MyClient(MyService service) {
		super();
		this.service = service;
	}
	
	public void setMyService(MyService service) {
		this.service = service;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void showMessage() {
		System.out.printf("%s -> %s%n", name, service.message());
	}
}
