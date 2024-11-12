package com.jdc.spring.jpa.repo.jpql;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.jdc.spring.jpa.repo.CustomerRepositoryBase;

@Repository
public class CustomerRepoJpql extends CustomerRepositoryBase{

	@Override
	public int update(int id, String name, String phone) {
		
		var query = em.createNamedQuery("Customer.update");
		query.setParameter("name", name);
		query.setParameter("phone", phone);
		query.setParameter("now", LocalDateTime.now());
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	@Override
	public int delete(int id) {
		var query = em.createNamedQuery("Customer.delete");
		query.setParameter("id", id);
		return query.executeUpdate();
	}

}
