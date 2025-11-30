package com.jdc.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import com.jdc.security.model.entity.Account;
import com.jdc.security.model.entity.Account.Role;
import com.jdc.security.model.repo.AccountRepo;
import com.jdc.security.model.service.JwtTokenFilter;
import com.jdc.security.utils.exception.SecurityExceptionHandler;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		http.csrf(csrf -> csrf.disable());
		http.cors(withDefaults());
		http.sessionManagement(session -> {
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		});
		
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/auth/**").permitAll();
			request.requestMatchers("/admin/**").hasAuthority("Admin");
			request.requestMatchers("/member/**").hasAnyAuthority("Admin", "Member");
			request.anyRequest().authenticated();
		});
		
		http.addFilterAfter(jwtTokenFilter(), ExceptionTranslationFilter.class);
		
		http.exceptionHandling(exception -> {
			exception.authenticationEntryPoint(securityExceptionHandler());
			exception.accessDeniedHandler(securityExceptionHandler());
		});
		
		return http.build();
	}
		
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	ApplicationRunner applicationRunner(AccountRepo accountRepo) {
		return _ -> {
			if(accountRepo.count() == 0L) {
				var admin = new Account();
				admin.setName("Admin User");
				admin.setEmail("admin@gmail.com");
				admin.setRole(Role.Admin);
				admin.setPassword(passwordEncoder().encode("password"));
				admin.setActivatedAt(LocalDateTime.now());
				accountRepo.save(admin);
			}
		};
	}
	
	@Bean
	SecurityExceptionHandler securityExceptionHandler() {
		return new SecurityExceptionHandler();
	}
	
}
