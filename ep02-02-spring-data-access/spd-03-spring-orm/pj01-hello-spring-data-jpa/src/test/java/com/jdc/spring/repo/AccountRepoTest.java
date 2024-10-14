package com.jdc.spring.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.repo.AccountRepo;

@SpringBootTest
public class AccountRepoTest {
	
	@Autowired
	private AccountRepo repo;

	@Test
	void loadConfig() {
		var account = new Account();
		account.setCode("C001");
		account.setName("Aung Aung");
		account.setPhone("09181817171");
		account.setEmail("aungaung@gmail.com");
		
		repo.save(account);
	}
}
