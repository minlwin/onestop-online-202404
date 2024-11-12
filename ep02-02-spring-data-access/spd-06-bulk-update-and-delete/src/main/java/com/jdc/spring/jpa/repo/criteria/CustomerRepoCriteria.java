package com.jdc.spring.jpa.repo.criteria;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.jdc.spring.jpa.entity.Customer;
import com.jdc.spring.jpa.entity.Customer_;
import com.jdc.spring.jpa.repo.CustomerRepositoryBase;

@Repository
public class CustomerRepoCriteria extends CustomerRepositoryBase{

	@Override
	public int update(int id, String name, String phone) {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createCriteriaUpdate(Customer.class);
		var root = cq.from(Customer.class);
		
		cq.set(root.get(Customer_.name), name);
		cq.set(root.get(Customer_.phone), phone);
		cq.set(root.get(Customer_.lastModifiedAt), LocalDateTime.now());
		
		cq.where(cb.equal(root.get(Customer_.id), id));
		
		return em.createQuery(cq).executeUpdate();
	}

	@Override
	public int delete(int id) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createCriteriaDelete(Customer.class);
		var root = cq.from(Customer.class);
		cq.where(cb.equal(root.get(Customer_.id), id));
		return em.createQuery(cq).executeUpdate();
	}

}
