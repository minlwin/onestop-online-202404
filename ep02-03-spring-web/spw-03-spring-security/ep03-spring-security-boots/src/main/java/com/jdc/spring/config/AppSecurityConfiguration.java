package com.jdc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class AppSecurityConfiguration {

	@Bean
	SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(req -> {
			req.dispatcherTypeMatchers(DispatcherType.ERROR, DispatcherType.FORWARD, DispatcherType.INCLUDE)
				.permitAll();
			req.requestMatchers("/", "/resources/**").permitAll();
			req.requestMatchers("/admin/**").hasAuthority("Admin");
			req.requestMatchers("/member/**").hasAnyAuthority("Admin", "Member");
			req.anyRequest().authenticated();
		});
		
		http.formLogin(login -> {});
		http.logout(logout -> {});
		
		return http.build();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder().username("admin").authorities("Admin").password("{noop}admin").build(),
			User.builder().username("member").authorities("Member").password("{noop}member").build()
		);
	}
}
