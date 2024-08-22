package com.jdc.spring.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MyClient {

	@Autowired
	private List<MyService> service;
	
	public void showMessage() {
		service.forEach(a -> System.out.println(a.getMessage()));
	}
}
