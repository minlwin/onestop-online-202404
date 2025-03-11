package com.jdc.online.balances.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdc.online.balances.utils.BalanceTypeConverter;

@Configuration
public class WebApplicationConfig implements WebMvcConfigurer{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new BalanceTypeConverter());
	}
}
