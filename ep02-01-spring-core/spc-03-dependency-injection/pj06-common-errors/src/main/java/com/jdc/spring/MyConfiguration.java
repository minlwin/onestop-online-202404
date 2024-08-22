package com.jdc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jdc.spring.beans.MyClient;

@Configuration
@ComponentScan(basePackages = "com.jdc.spring.beans")
public class MyConfiguration {

	@Bean
	MyClient myClient() {
		return new MyClient();
	}

}
