package com.jdc.spring.jpa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.ApplicationConfig;
import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.repo.AccountRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class SpringOrmDemo {
	
	@Autowired
	private AccountRepo repo;

	@ParameterizedTest
	@CsvSource("C001,Nilar,0918181717,thidar@gmail.com")
	void createAccount(String code, String name, String phone, String email) {
		
		var account = new Account(code, name, phone, email);
		repo.create(account);
	}

}
