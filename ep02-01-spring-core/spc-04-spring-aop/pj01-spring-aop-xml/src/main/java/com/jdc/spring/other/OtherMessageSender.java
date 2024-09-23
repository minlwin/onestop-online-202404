package com.jdc.spring.other;

import org.springframework.stereotype.Service;

import com.jdc.spring.aop.annotations.SecuredService;

@Service
@SecuredService
public class OtherMessageSender {

	public void send(int count, String message) {
		
		for(var i = 1; i <= count; i ++) {
			System.out.printf("Sending Other %d: %s%n", i, message);
		}
	}
	
	public int twice(int value) {
		System.out.printf("Twice of %d is %d%n", value, value * 2);
		return value * 2;
	}
	
	public void send(String message) {
		System.out.printf("Sending %s%n", message);
	}
}
