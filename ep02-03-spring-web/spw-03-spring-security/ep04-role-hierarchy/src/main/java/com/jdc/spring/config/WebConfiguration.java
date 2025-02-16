package com.jdc.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/member").setViewName("member");
		registry.addViewController("/staff").setViewName("staff");
		registry.addViewController("/manager").setViewName("manager");
		registry.addViewController("/admin").setViewName("admin");
	}
}
