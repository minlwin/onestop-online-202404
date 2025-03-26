package com.jdc.online.balances.model.repo;

import java.util.Optional;

import com.jdc.online.balances.model.BaseRepository;
import com.jdc.online.balances.model.entity.Member;

public interface MemberRepo extends BaseRepository<Member, Long>{

	Optional<Member> findOneByAccountUsername(String username);

}
