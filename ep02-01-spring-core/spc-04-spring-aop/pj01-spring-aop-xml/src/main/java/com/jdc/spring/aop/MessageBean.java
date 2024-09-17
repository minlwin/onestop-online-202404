package com.jdc.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class MessageBean implements MessageService {

	private int times = 0;
	
	@Override
	public int send(String message) {
		// Business Logic
		System.out.printf("Sending Message : %s%n", message);
		times ++;
		return times;
	}
	
	@Override
	public void hello() {
		System.out.println("Hello Method");
	}
}
