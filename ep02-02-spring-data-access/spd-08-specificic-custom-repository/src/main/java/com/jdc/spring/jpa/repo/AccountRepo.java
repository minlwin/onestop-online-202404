package com.jdc.spring.jpa.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;

import com.jdc.spring.jpa.base.BaseRepository;
import com.jdc.spring.jpa.entity.Account;
import com.jdc.spring.jpa.entity.Account.Role;

public interface AccountRepo extends BaseRepository<Account, UUID>{

	Optional<Account> findOneByLoginId(String loginId);
	List<Account> findByRole(Role role);
	
	@Query("select a from Account a where a.role = :role and a.activatedAt <= :now and a.expiredAt >= :now")
	List<Account> searchActiveAccount(Role role, LocalDateTime now);
}
