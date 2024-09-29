package com.jdc.spring.aop;

import org.springframework.aop.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jdc.spring.aop")
public class ApplicationConfig {

	Pointcut serviceMethod() {
		return null;
	}
}
