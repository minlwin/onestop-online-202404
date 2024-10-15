package com.jdc.spring.jpa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.spring.model.entity.Account;

import jakarta.persistence.Persistence;

public class JpaDemo {

	@ParameterizedTest
	@CsvSource("C001,Thidar,0918181717,thidar@gmail.com")
	void createAccount(String code, String name, String phone, String email) {
		
		var account = new Account(code, name, phone, email);
		
		var emf = Persistence.createEntityManagerFactory("pj02-jpa-without-spring");
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		em.getTransaction().commit();
	}
}
