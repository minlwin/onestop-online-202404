package com.jdc.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages = "com.jdc.spring.jdbc.dao")
public class ApplicationConfig {

	@Bean
	EmbeddedDatabase embeddedDatabase() {
		return new EmbeddedDatabaseBuilder()
				.addScript("classpath:/schema.sql")
				.setType(EmbeddedDatabaseType.H2)
				.build();
	}
}
