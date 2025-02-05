package com.jdc.spring.model.repo;

import java.util.Optional;

import com.jdc.spring.model.BaseRepository;
import com.jdc.spring.model.entity.Account;

public interface AccountRepo extends BaseRepository<Account, Integer>{

	Optional<Account> findOneByEmail(String email);

	long countByEmail(String email);
}
