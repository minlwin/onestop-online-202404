package com.jdc.fetches.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.fetches.api.dto.DivisionListItem;
import com.jdc.fetches.model.entity.Division;

public interface DivisionRepo extends JpaRepository<Division, Integer> {

	@Query("select new com.jdc.fetches.api.dto.DivisionListItem(d.id, d.name, d.capital) from Division d")
	List<DivisionListItem> getAll();

}
