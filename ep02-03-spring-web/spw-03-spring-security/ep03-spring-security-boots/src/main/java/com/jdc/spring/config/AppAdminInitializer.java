package com.jdc.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account.Role;
import com.jdc.spring.model.repo.AccountRepo;

@Configuration
public class AppAdminInitializer {

	@Autowired
	private AccountRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@EventListener(classes = ContextRefreshedEvent.class)
	public void initialize() {
		if(repo.count() == 0L) {
			var admin = new Account();
			admin.setName("Admin User");
			admin.setEmail("admin@gmail.com");
			admin.setRole(Role.Admin);
			admin.setPassword(passwordEncoder.encode("admin"));
			repo.save(admin);
		}
	}
}
