package com.jdc.online.balances.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.online.balances.model.BaseRepositoryImpl;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.jdc.online.balances.model",
		repositoryBaseClass = BaseRepositoryImpl.class
)
public class JpaApplicationConfig {

}
