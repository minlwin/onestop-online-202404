package com.jdc.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class AdviceArgumentsDemo {

	public int getLength(String message) {
		System.out.printf("Message is %s.%n", message);
		return message.length();
	}
}
