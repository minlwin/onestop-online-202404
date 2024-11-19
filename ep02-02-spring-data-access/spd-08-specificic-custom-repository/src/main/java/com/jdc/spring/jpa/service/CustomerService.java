package com.jdc.spring.jpa.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.spring.jpa.dto.input.CustomerSearch;
import com.jdc.spring.jpa.dto.output.CustomerDto;
import com.jdc.spring.jpa.entity.Account_;
import com.jdc.spring.jpa.entity.Customer;
import com.jdc.spring.jpa.entity.Customer_;
import com.jdc.spring.jpa.repo.CustomerRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public List<CustomerDto> search(CustomerSearch search) {
		
		Function<CriteriaBuilder, CriteriaQuery<CustomerDto>> queryFunc = cb -> {
			var cq = cb.createQuery(CustomerDto.class);
			var root = cq.from(Customer.class);
			CustomerDto.select(cq, root);
			cq.where(search.where(cb, root));
			cq.orderBy(cb.desc(root.get(Customer_.account).get(Account_.activatedAt)));
			return cq;
		};
		
		return customerRepo.search(queryFunc);
	}
}
