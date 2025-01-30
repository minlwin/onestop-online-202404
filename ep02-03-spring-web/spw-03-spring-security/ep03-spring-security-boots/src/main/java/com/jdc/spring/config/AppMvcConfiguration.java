package com.jdc.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppMvcConfiguration implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/authenticate").setViewName("login");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/member").setViewName("member");
	}
}
