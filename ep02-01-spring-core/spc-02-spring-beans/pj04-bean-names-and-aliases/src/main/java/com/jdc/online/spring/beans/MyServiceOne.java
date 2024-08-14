package com.jdc.online.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class MyServiceOne implements MyService{

	@Override
	public String message() {
		return "Message from MyService One";
	}

}
