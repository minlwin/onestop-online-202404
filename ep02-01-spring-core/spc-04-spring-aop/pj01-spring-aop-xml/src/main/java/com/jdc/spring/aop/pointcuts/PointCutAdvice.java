package com.jdc.spring.aop.pointcuts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointCutAdvice {
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

	public void before(JoinPoint joinpoint) {
		
		var className = joinpoint.getTarget().getClass().getSimpleName();
		var methodName = joinpoint.getSignature().getName();
		var executeAt = LocalDateTime.now().format(DF);
		
		System.out.printf("%s#%s is executed at %s%n", className, methodName, executeAt);
	}

	public void beforeWithArgs(JoinPoint joinpoint, int value) {
		
		var className = joinpoint.getTarget().getClass().getSimpleName();
		var methodName = joinpoint.getSignature().getName();
		var executeAt = LocalDateTime.now().format(DF);
		
		System.out.printf("%s#%s is executed at %s%n", className, methodName, executeAt);
		System.out.printf("Argument is %d%n", value);
	}
}
