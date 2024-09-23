package com.jdc.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.aop.beans.BeanWithAnnotatedType;

@SpringJUnitConfig(locations = "classpath:/on-type-within.xml")
public class AnnotatedTypeAspectWithinTest {

	@Autowired
	private BeanWithAnnotatedType bean;
	
	@Test
	void test() {
		
		bean.methodFromBase();
		
		System.out.println();
		
		bean.ownMethod();
	}

}
