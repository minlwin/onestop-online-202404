package com.jdc.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jdc.ioc.bean")
public class ApplicationConfig {

	@Bean
	HelloBean helloBean() {
		return new HelloBean();
	}
}
