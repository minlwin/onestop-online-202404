package com.jdc.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jdc.spring.model")
public class ApplicationConfig {
	
	@Bean
	BasicDataSource dataSource() {
		var bean = new BasicDataSource();
		bean.setUrl("jdbc:mysql://localhost:3306/orm01db");
		bean.setUsername("ormusr");
		bean.setPassword("ormpwd");
		return bean;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var bean = new LocalContainerEntityManagerFactoryBean();
		
		bean.setDataSource(dataSource());
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

		bean.setPackagesToScan("com.jdc.spring.model.entity");
		bean.setJpaPropertyMap(getJpaProperties());
		
		return bean;
	}
	
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		var bean = new JpaTransactionManager();
		bean.setEntityManagerFactory(entityManagerFactory);
		return bean;
	}

	private Map<String, ?> getJpaProperties() {
		var props = new HashMap<String, Object>();
		props.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		return props;
	}
}
