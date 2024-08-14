package com.jdc.online.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jdc.online.spring.beans.MyService;
import com.jdc.online.spring.beans.MyServiceOne;

@Configuration
@ComponentScan(basePackages = "com.jdc.online.spring.beans")
public class MyConfiguration {

	@Bean(name = {
			"myService",
			"defaultService"
	})
	MyService myService() {
		return new MyServiceOne();
	}
}
