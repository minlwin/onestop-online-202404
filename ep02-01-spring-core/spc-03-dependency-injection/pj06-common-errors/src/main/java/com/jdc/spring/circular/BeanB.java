package com.jdc.spring.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

	private BeanC bean;

	public BeanB(BeanC bean) {
		super();
		this.bean = bean;
	}
	
	public void doSomething() {
		bean.sayHello();
	}

	public void sayHello() {
		System.out.println("Hello From Bean B");
	}

}
