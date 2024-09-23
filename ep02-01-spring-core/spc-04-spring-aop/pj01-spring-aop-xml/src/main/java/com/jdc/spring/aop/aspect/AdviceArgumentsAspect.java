package com.jdc.spring.aop.aspect;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AdviceArgumentsAspect {

	public void before(String arg) {
		System.out.println("Before Advice");
		System.out.printf("Argument is %s%n", arg);
	}
	
	public void afterReturning(String input, int result) {
		System.out.println("After Returning Advice");
		System.out.printf("Argument is %s%n", input);
		System.out.printf("Result is %s%n", result);
	}
	
	public void afterThrowing(String input, Exception ex) {
		System.out.println("After Throwing Advice");
		System.out.printf("Argument is %s%n", input);
		System.out.printf("Throwing %s%n", ex.getClass().getSimpleName());
	}
	
	public void after(String input) {
		System.out.println("After Advice");
		System.out.printf("Argument is %s%n", input);
	}

}
