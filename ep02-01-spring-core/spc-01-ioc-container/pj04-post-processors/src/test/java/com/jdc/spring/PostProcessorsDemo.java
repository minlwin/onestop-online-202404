package com.jdc.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.spring.beans.MyBean;

public class PostProcessorsDemo {

	@Test
	void demo() {
		
		try(var context = new GenericXmlApplicationContext("classpath:/application.xml")) {
			
			var myBean = context.getBean(MyBean.class);
			System.out.println(myBean.getValue());
		}
		
	}
}
