package com.jdc.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.annotation.Configuration;

import com.jdc.spring.aop.OnMethod;

@Configuration
public class AnnotatedMethodAspect {

	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint);
	}
	
	public void beforeWithAnnotation(JoinPoint joinPoint, OnMethod onMethod) {
		System.out.println(joinPoint);
		System.out.printf("Value of annotation is %s%n", onMethod.value());
	}
	
}
