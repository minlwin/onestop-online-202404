package com.jdc.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Configuration;

@Configuration("aroundAspect")
public class AroundAdviceAspect {

	public Object around(ProceedingJoinPoint joinPoint, String input) throws Throwable {
		
		try {
			
			// Before Advice
			System.out.printf("Before Input : %s%n", input);
			
			var result = joinPoint.proceed();
			
			// After Returning Advice
			System.out.printf("After Returning : %s%n", result);

			return result;
		} catch(Throwable ex) {
			// After Throwing Advice
			System.out.printf("After Throwing : %s%n", ex.getClass().getSimpleName());
			throw ex;
		} finally {
			// After Advice
			System.out.println("After Finally");
		}
	}
}
