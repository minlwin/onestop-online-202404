package com.jdc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

import com.jdc.spring.beans.MyClient;
import com.jdc.spring.beans.MyService;

@Configuration
public class MyConfiguration {

	@Bean
	@Order(1)
	MyService service1() {
		return new MyService("Service 1");
	}
	
	@Bean
	@Order(2)
	MyService service2() {
		return new MyService("Service 2");
	}

	@Bean
	@Order(3)
	MyService service3() {
		return new MyService("Service 3");
	}

	@Bean
	@Lazy
	MyClient myClient() {
		return new MyClient();
	}
}
