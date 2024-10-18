package com.jdc.spring.orm.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.orm.entity.AgentShop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AgentShopRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void create(AgentShop shop) {
		em.persist(shop);
	}
}
