package com.jdc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.spring.beans.MyClient;
import com.jdc.spring.beans.MyService;

@Configuration
public class MyConfiguration {

	@Bean
	MyService myService() {
		return new MyService();
	}
	
	@Bean
	MyClient myClient() {
		return new MyClient();
	}
}
