package com.jdc.spring.jdbc.repository;

import java.util.List;
import java.util.Optional;

import com.jdc.spring.jdbc.domain.DistrictDto;

public interface DistrictRepo {

	List<DistrictDto> search(Integer divisionId, String name);
	
	Optional<DistrictDto> findById(int id);
}
