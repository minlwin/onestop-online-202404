package com.jdc.spring.jdbc.repository.named;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.jdc.spring.jdbc.domain.DivisionDto;
import com.jdc.spring.jdbc.repository.DivisionRepo;

@Repository
@Profile("named")
public class DivisionRepoNamedParameterJdbcTemplate implements DivisionRepo {

	@Override
	public List<DivisionDto> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DivisionDto> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
