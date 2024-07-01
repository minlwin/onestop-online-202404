package com.jdc.demo;

public class Client {

	private Service service;
	
	public Client() {
		service = new Service();
	}
	
	public void doSomething() {
		
		service.methodThrowingUncheckedException();
	}
}
