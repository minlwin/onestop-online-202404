package com.jdc.online.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.jdc.online.spring.beans.InitializableBean;
import com.jdc.online.spring.beans.MyService;

@Configuration
public class ApplicationConfig {

	@Bean
	@Lazy
	MyService myService() {
		return new MyService();
	}
	
	@Bean
	@Scope("prototype")
	MyService prototypeService() {
		return new MyService();
	}
	
	@Bean(initMethod = "init", destroyMethod = "cleanUp")
	InitializableBean initializableBean() {
		return new InitializableBean();
	}
}
