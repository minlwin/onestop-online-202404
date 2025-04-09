package com.jdc.online.balances.model.repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jdc.online.balances.model.BaseRepository;
import com.jdc.online.balances.model.entity.MemberActivity;

public interface MemberActivityRepo extends BaseRepository<MemberActivity, Long>{

	@Modifying
	@Query(value = "update MemberActivity a set a.lastAccessAt = :lastAccessAt where a.member.account.username = :username")
	int updateLastAccess(LocalDateTime lastAccessAt, String username);

	Long countByRegisteredAtIsGreaterThanEqual(LocalDateTime atStartOfDay);
}
