package com.jdc.fetches.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.fetches.api.dto.DivisionListItem;
import com.jdc.fetches.model.repo.DivisionRepo;

@Service
public class DivisionService {

	@Autowired
	private DivisionRepo repo;
	
	@Transactional(readOnly = true)
	public List<DivisionListItem> findAll() {
		return repo.getAll();
	}

}
