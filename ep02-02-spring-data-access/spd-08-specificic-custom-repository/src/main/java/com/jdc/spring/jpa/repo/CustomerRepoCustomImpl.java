package com.jdc.spring.jpa.repo;

import java.util.List;

import com.jdc.spring.jpa.dto.input.CustomerSearch;
import com.jdc.spring.jpa.dto.output.CustomerDto;
import com.jdc.spring.jpa.entity.Account_;
import com.jdc.spring.jpa.entity.Customer;
import com.jdc.spring.jpa.entity.Customer_;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CustomerRepoCustomImpl implements CustomerRepoCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CustomerDto> search(CustomerSearch search) {
		
		var cb = entityManager.getCriteriaBuilder();
		var cq = cb.createQuery(CustomerDto.class);
		
		var root = cq.from(Customer.class);
		
		CustomerDto.select(cq, root);
		
		if(null != search) {
			cq.where(search.where(cb, root));
		}
		
		cq.orderBy(cb.desc(root.get(Customer_.account).get(Account_.activatedAt)));
		
		return entityManager.createQuery(cq).getResultList();
	}

}
