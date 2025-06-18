package com.jdc.online.location.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.online.location.model.entity.Region;
import com.jdc.online.location.model.repo.RegionRepo;

@RestController
@RequestMapping("regions")
public class RegionApi {
	
	@Autowired
	private RegionRepo repo;

	@GetMapping
	List<Region> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	Region findById(@PathVariable int id) {
		return repo.findById(id)
				.orElseThrow();
	}
}
