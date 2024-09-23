package com.jdc.spring.aop;

import org.springframework.stereotype.Component;

import com.jdc.spring.aop.annotations.SecuredMethod;

@Component
public class AdviceArgumentsDemo {

	@SecuredMethod
	public int getLength(String message) {
		System.out.printf("Message is %s.%n", message);
		return message.length();
	}
}
