package com.jdc.spring.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
	
	@Autowired
	private BeanB bean;
	
	public void doSomething() {
		bean.sayHello();
	}

	public void seayHello() {
		System.out.println("Hello from Bean B");
	}

}
