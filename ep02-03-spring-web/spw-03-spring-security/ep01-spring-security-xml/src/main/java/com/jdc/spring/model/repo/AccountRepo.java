package com.jdc.spring.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.model.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

	Optional<Account> findOneByEmail(String email);

	long countByEmail(String email);
}
