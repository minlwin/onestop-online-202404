package com.jdc.online.location;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.online.location.model.BaseRepositoryImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class LocationApiJpaConfig {

}
