package com.jdc.spring.trx;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {
	"com.jdc.spring.trx.service",
	"com.jdc.spring.trx.repo"
})
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	DataSource dataSource() {
		var bean = new HikariDataSource();
		bean.setJdbcUrl("jdbc:mysql://localhost:3306/trx01db");
		bean.setUsername("trx01db");
		bean.setPassword("trx01db");
		return bean;
	}
	
	@Bean
	PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	DataSourceInitializer dataSourceInitializer() {
		var bean = new DataSourceInitializer();
		bean.setDataSource(dataSource());
		
		var populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/schema.sql"));
		populator.addScript(new ClassPathResource("/data.sql"));
		
		bean.setDatabasePopulator(populator);
		
		return bean;
	}
	
}
