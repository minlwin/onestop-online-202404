package com.jdc.spring.beans;

public class MyServiceFactory {

	public MyService myService() {
		return new MyService("From Instance Factory Method");
	}
}
