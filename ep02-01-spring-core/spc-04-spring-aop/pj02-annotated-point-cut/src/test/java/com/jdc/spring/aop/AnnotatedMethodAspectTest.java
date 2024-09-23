package com.jdc.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.aop.beans.BeanWithAnnotatedMethod;

@SpringJUnitConfig(locations = "classpath:/on-method.xml")
public class AnnotatedMethodAspectTest {

	@Autowired
	private BeanWithAnnotatedMethod bean;
	
	@Test
	void test() {
		
		bean.methodWithoutAnnotation();
		
		System.out.println();
		
		bean.methodWithAnnotation();
	}
}
