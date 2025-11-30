package com.jdc.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import com.jdc.security.model.service.JwtTokenFilter;

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
	
}
