package com.jdc.spring.aop.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class AppMethodInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object result = null;
		
		try {
			
			System.out.printf("Before Advice at %s%n", invocation.getMethod().getName());
			
			result = invocation.proceed();
			
			System.out.printf("After Returning Advice at %s%n", invocation.getMethod().getName());
		} catch(Throwable e) {
			System.out.printf("After Throwing Advice at %s%n", invocation.getMethod().getName());
			throw e;
		} finally {
			System.out.printf("After Advice at %s%n", invocation.getMethod().getName());
		}
		
		return result;
	}

}
