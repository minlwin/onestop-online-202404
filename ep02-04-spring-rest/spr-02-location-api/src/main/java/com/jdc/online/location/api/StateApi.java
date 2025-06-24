package com.jdc.online.location.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.online.location.api.dto.StateSearch;
import com.jdc.online.location.model.entity.State;
import com.jdc.online.location.model.repo.StateRepo;

@RestController
@RequestMapping("states")
public class StateApi {

	@Autowired
	private StateRepo repo;
	
	@GetMapping
	List<State> search(StateSearch search) {
		return repo.search(search.queryFunc());
	}
	
	@GetMapping("{id}")
	State findById(@PathVariable int id) {
		return repo.findById(id)
				.orElseThrow();
	}
}
