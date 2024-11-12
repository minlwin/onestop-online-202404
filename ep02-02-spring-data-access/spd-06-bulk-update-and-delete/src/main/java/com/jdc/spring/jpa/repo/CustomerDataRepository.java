package com.jdc.spring.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.Customer;

public interface CustomerDataRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByNameLike(String name);
	
	@Modifying
	@Transactional
	@Query(value = "update Customer c set c.name = ?1, c.phone = ?2 where c.id = ?3")
	int updateCustomer(String name, String phone, int id);
}
