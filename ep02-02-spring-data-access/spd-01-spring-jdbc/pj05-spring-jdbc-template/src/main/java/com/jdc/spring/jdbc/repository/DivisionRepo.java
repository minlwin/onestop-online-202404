package com.jdc.spring.jdbc.repository;

import java.util.List;
import java.util.Optional;

import com.jdc.spring.jdbc.domain.DivisionDto;

public interface DivisionRepo {

	List<DivisionDto> search(String name);
	
	Optional<DivisionDto> findById(int id);
}
