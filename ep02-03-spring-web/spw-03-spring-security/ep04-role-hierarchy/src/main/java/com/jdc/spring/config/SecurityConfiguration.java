package com.jdc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/", "/login").permitAll();
			request.requestMatchers("/admin/**").hasRole("ADMIN");
			request.requestMatchers("/manager/**").hasRole("MANAGER");
			request.requestMatchers("/staff/**").hasRole("STAFF");
			request.requestMatchers("/member/**").hasRole("MEMBER");
			request.anyRequest().authenticated();
		});
		
		http.formLogin(form -> {});
		http.logout(logout -> {});
		
		return http.build();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder().username("member").roles("MEMBER").authorities("Read", "Create").password("{noop}member").build(),
			User.builder().username("staff").roles("STAFF").authorities("Read", "Create").password("{noop}staff").build(),
			User.builder().username("manager").roles("MANAGER").authorities("Read", "Create", "Update").password("{noop}manager").build(),
			User.builder().username("admin").roles("ADMIN").password("{noop}admin").build()
		);
	}
	
	@Bean
	RoleHierarchy roleHierarchy() {
		return RoleHierarchyImpl.fromHierarchy("""
				ROLE_ADMIN > ROLE_MANAGER
				ROLE_MANAGER > ROLE_STAFF
				ROLE_STAFF > ROLE_MEMBER
				""");
	}
}
