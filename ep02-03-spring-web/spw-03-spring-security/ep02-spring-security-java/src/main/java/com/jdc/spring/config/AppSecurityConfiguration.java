package com.jdc.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.jdc.spring.service.AppAuthFailureHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {
	"com.jdc.spring.model.repo",
	"com.jdc.spring.service"
})
public class AppSecurityConfiguration {

	@Bean
	SecurityFilterChain httpSecurity(
			HttpSecurity http, 
			PersistentTokenRepository persistentTokenRepository) throws Exception {
		
		http.authorizeHttpRequests(req -> {
			req.requestMatchers("/", "/signup", "/authenticate", "/resources/**").permitAll();
			req.requestMatchers("/admin/**").hasAuthority("Admin");
			req.requestMatchers("/member/**").hasAnyAuthority("Admin", "Member");
			req.anyRequest().authenticated();
		});
		
		http.formLogin(form -> {
			form.loginPage("/authenticate");
			form.failureHandler(new AppAuthFailureHandler());
		});
		
		http.rememberMe(rememberMe -> {
			rememberMe.tokenRepository(persistentTokenRepository);
		});
		
		http.logout(logout -> {});
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
		var bean = new JdbcTokenRepositoryImpl();
		bean.setDataSource(dataSource);
		// Create Table on first time
		// bean.setCreateTableOnStartup(true);
		return bean;
	}


}
