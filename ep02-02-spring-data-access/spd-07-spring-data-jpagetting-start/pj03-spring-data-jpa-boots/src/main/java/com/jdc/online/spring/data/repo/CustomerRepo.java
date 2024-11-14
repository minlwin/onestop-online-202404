package com.jdc.online.spring.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.online.spring.data.dto.CustomerDto;
import com.jdc.online.spring.data.dto.CustomerName;
import com.jdc.online.spring.data.dto.IdAndName;
import com.jdc.online.spring.data.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	List<Customer> findByNameStartsWithIgnoreCase(String name);
	
	@Query(
		value = "select * from customer where lower(name) like :keyword or phone like :keyword or email like :keyword", 
		nativeQuery = true)
	List<Customer> findByKeyword(@Param("keyword") String param);
	
	List<CustomerName> findNameByPhoneStartsWith(String phone);
	
	IdAndName findIdNameById(int id);
	
	CustomerDto findIdNamePhoneById(int id);
	
}
