package com.jdc.spring.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.model.entity.Account;

public interface AccountRepo extends JpaRepository<Account, String>{

}
