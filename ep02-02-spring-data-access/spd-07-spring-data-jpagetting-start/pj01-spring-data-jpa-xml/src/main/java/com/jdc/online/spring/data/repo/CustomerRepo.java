package com.jdc.online.spring.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.online.spring.data.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
