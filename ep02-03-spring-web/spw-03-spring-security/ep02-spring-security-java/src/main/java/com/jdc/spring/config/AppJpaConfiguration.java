package com.jdc.spring.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.jdc.spring.model.repo")
public class AppJpaConfiguration {

	@Bean
	DataSource dataSource() {
		var bean = new BasicDataSource();
		bean.setDriverClassName("org.h2.Driver");
		bean.setUrl("jdbc:h2:file:./java/database");
		bean.setUsername("sa");
		bean.setPassword("sa");
		return bean;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		bean.setPackagesToScan("com.jdc.spring.model.entity");
		bean.setJpaPropertyMap(getProperties());
		return bean;
	}
	
	private Map<String, Object> getProperties() {
		var props = new HashMap<String, Object>();

		props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.put("hibernate.hbm2ddl.auto", "create");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		
		return props;
	}

	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
