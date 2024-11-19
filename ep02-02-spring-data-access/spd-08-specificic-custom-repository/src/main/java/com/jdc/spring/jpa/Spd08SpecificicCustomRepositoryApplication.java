package com.jdc.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.spring.jpa.base.BaseRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class Spd08SpecificicCustomRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spd08SpecificicCustomRepositoryApplication.class, args);
	}

}
