package com.jdc.spring.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanC {

	private BeanA bean;

	public BeanC(BeanA bean) {
		super();
		this.bean = bean;
	}
	
	public void doSomething() {
		bean.seayHello();
	}

	public void sayHello() {
		System.out.println("Hello from Bean A");
	}
	
}
