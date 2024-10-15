package com.jdc.spring.model.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AccountRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void create(Account account) {
		em.persist(account);
	}
}
