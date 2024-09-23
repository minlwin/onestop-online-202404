package com.jdc.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.annotation.Configuration;

import com.jdc.spring.aop.OnArgument;

@Configuration
public class AnnotatedArgsAspect {

	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint);
	}
	
	public void beforeWithAnnotation(JoinPoint joinPoint, OnArgument onArgs) {
		System.out.println(joinPoint);
		System.out.printf("Value of Annotation is %s%n", onArgs.value());
	}
}
