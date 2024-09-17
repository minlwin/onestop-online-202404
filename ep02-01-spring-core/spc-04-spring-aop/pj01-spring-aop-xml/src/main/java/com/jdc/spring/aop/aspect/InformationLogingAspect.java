package com.jdc.spring.aop.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;

public class InformationLogingAspect {

	public void before(JoinPoint joinPoint) {
		
		System.out.printf("""
				toString          : %s
				toShortString     : %s
				toLongString      : %s
				getKind           : %s
				getSignature      : %s
				getSourceLocation : %s
				""", 
				joinPoint.toString(),
				joinPoint.toShortString(),
				joinPoint.toLongString(),
				joinPoint.getKind(),
				joinPoint.getSignature(),
				joinPoint.getSourceLocation());
		
		for(var input : joinPoint.getArgs()) {
			System.out.printf("Input : %s%n", input);
		}
	}
	
	public void after() {
		System.out.printf("End At : %s%n%n", LocalDateTime.now());
	}
	
	public void afterReturning(Object result) {
		System.out.printf("Result is : %s%n", result);
	}
}
