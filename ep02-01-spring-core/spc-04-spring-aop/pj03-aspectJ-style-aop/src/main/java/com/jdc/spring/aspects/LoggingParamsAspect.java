package com.jdc.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingParamsAspect {

	@Pointcut("within(com.jdc..service.*)")
	public void serviceMethods() {}
	
	@Before("serviceMethods() && @annotation(com.jdc.spring.aspects.LogParams)")
	public void beforeAdvice(JoinPoint joinPoint) {

		System.out.println(joinPoint);
		
		var arguments = joinPoint.getArgs();
		for(var i = 0; i < arguments.length; i ++) {
			System.out.printf("Argument %d : %s%n", i + 1, arguments[i]);
		}
		
	}
}
