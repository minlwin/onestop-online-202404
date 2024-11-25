package com.jdc.spring.locking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.jdc.spring.locking.entity.Customer;

import jakarta.persistence.LockModeType;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	@Override
	@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
	Optional<Customer> findById(Integer id);
	
}
