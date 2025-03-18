package com.jdc.online.balances.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.model.entity.Account;
import com.jdc.online.balances.model.entity.consts.Role;
import com.jdc.online.balances.model.repo.AccountRepo;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@PropertySource(value = "classpath:/admin-user.properties")
public class AdminUserInitializer {
	
	private final PasswordEncoder passwordEncoder;
	private final AccountRepo accountRepo;
	
	@Value("${app.admin.username}")
	private String username;
	@Value("${app.admin.password}")
	private String password;

	@PostConstruct
	@Transactional
	public void initialize() {
		
		if(accountRepo.count() == 0L) {
			var admin = new Account();
			admin.setUsername(username);
			admin.setPassword(passwordEncoder.encode(password));
			admin.setRole(Role.Admin);
			admin.setActive(true);
			accountRepo.save(admin);
		}
	}
}
