package com.jdc.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.aop.args.Wrapper;
import com.jdc.spring.aop.beans.BeanUsingArguments;

@SpringJUnitConfig(locations = "classpath:/on-argument.xml")
public class AnnotatedArgsAspectTest {

	@Autowired
	private BeanUsingArguments bean;
	
	@Test
	void test() {
		bean.useString("String message");
		System.out.println();
		bean.useWrapper(new Wrapper("Wrapped Value"));
	}
}
