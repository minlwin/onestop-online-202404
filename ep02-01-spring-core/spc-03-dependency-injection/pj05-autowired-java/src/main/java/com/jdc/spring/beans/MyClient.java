package com.jdc.spring.beans;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class MyClient {

	@Autowired
	private Optional<MyService> service;
	
	public void showMessage() {
		System.out.println(
				service.map(a -> a.getMessage())
				.orElse("Default Message"));
	}
}
