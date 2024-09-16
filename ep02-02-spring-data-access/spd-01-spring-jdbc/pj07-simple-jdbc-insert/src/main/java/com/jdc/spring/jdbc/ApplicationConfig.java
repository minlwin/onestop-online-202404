package com.jdc.spring.jdbc;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootConfiguration
@ComponentScan(basePackages = "com.jdc.spring.jdbc.repo")
public class ApplicationConfig {

}
