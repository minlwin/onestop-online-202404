package com.jdc.spring.jdbc.repository;

import java.util.List;
import java.util.Optional;

import com.jdc.spring.jdbc.domain.TownshipDto;

public interface TownshipRepo {

	List<TownshipDto> search(Integer divisionId, Integer districtId, String name);
	
	Optional<TownshipDto> findById(int id);

}
