package com.jdc.spring.aop;

import org.springframework.stereotype.Service;

import com.jdc.spring.aop.annotations.SecuredArg;
import com.jdc.spring.aop.annotations.SecuredMethod;
import com.jdc.spring.aop.annotations.SecuredService;

@Service
@SecuredService
public class MessageBean implements MessageService {

	private int times = 0;
	
	@Override
	public int send(@SecuredArg String message) {
		// Business Logic
		System.out.printf("Sending Message : %s%n", message);
		times ++;
		return times;
	}
	
	@SecuredMethod
	@Override
	public void hello() {
		System.out.println("Hello Method");
	}
}
