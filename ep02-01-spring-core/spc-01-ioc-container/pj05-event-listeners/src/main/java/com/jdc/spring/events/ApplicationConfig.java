package com.jdc.spring.events;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
		"com.jdc.spring.events.listeners",
		"com.jdc.spring.events.publisher"
})
public class ApplicationConfig {

}
