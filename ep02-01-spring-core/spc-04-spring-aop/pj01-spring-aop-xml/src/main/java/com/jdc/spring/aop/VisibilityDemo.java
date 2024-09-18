package com.jdc.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class VisibilityDemo {

	public void publicMethod() {
		System.out.println("Public Method Execution");
		
		privateMethod();
		packagePrivateMethod();
		protectedMethod();
	}
	
	protected void protectedMethod() {
		System.out.println("Protected Method Execution");
	}
	
	private void privateMethod() {
		System.out.println("Private Method Execution");
	}
	
	void packagePrivateMethod() {
		System.out.println("Package Private Method Execution");
	}
}
