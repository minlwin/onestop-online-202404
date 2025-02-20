package com.jdc.spring.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authorization.AuthorizationEventPublisher;
import org.springframework.security.authorization.SpringAuthorizationEventPublisher;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/", "/login", "/resources/**").permitAll();
			request.requestMatchers("/admin" , "/admin/**").hasRole("ADMIN");
			request.requestMatchers("/manager", "/manager/**").hasRole("MANAGER");
			request.requestMatchers("/staff", "/staff/**").hasRole("STAFF");
			request.requestMatchers("/member", "/member/**").hasRole("MEMBER");
			request.anyRequest().authenticated();
		});
		
		http.formLogin(form -> {});
		http.logout(logout -> {});
		
		return http.build();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder().username("member").roles("MEMBER").password("{noop}member").build(),
			User.builder().username("staff").roles("STAFF").password("{noop}staff").build(),
			User.builder().username("manager").roles("MANAGER").password("{noop}manager").build(),
			User.builder().username("admin").roles("ADMIN").password("{noop}admin").build()
		);
	}
	
	@Bean
	RoleHierarchy roleHierarchy() {
		return RoleHierarchyImpl.fromHierarchy("""
				ROLE_ADMIN > ROLE_MANAGER
				ROLE_MANAGER > ROLE_STAFF
				ROLE_STAFF > ROLE_MEMBER""");
	}
	
	@Bean
	AuthorizationEventPublisher authorizationEventPublisher(ApplicationEventPublisher publisher) {
		return new SpringAuthorizationEventPublisher(publisher);
	}
}
