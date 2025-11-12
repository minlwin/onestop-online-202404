package com.jdc.security.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.security.model.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

	Optional<Account> findOneByEmail(String email);
}
