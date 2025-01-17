package com.jdc.spring.web.databinding;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdc.spring.web.databinding.controller.formatter.PriceFormatter;

@Configuration
public class WebApplicationMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/categories");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new PriceFormatter());
	}
}
