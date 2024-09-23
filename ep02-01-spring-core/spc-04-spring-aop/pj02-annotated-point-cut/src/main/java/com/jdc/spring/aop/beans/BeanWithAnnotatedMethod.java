package com.jdc.spring.aop.beans;

import org.springframework.stereotype.Service;

import com.jdc.spring.aop.OnMethod;
import com.jdc.spring.aop.OnMethod.Level;

@Service
public class BeanWithAnnotatedMethod {

	public void methodWithoutAnnotation() {
		System.out.println("BeanWithAnnotatedMethod#methodWithoutAnnotation()");
	}

	@OnMethod(Level.Primary)
	public void methodWithAnnotation() {
		System.out.println("BeanWithAnnotatedMethod#methodWithAnnotation()");
	}
}
