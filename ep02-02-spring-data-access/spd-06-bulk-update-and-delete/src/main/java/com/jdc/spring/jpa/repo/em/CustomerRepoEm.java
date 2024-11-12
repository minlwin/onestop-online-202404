package com.jdc.spring.jpa.repo.em;

import org.springframework.stereotype.Repository;

import com.jdc.spring.jpa.entity.Customer;
import com.jdc.spring.jpa.repo.CustomerRepositoryBase;

@Repository
public class CustomerRepoEm extends CustomerRepositoryBase {
	
	@Override
	public int update(int id, String name, String phone) {
		
		var entity = em.find(Customer.class, id);
		
		if(null != entity) {
			entity.setName(name);
			entity.setPhone(phone);
			return 1;
		}
		
		return 0;
	}

	@Override
	public int delete(int id) {
		
		var entity = em.find(Customer.class, id);
		
		if(null != entity) {
			em.remove(entity);
			return 1;
		}
		
		return 0;
	}

}
