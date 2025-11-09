package com.jdc.fetches.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.fetches.api.dto.DivisionListItem;
import com.jdc.fetches.model.DivisionService;

@RestController
@RequestMapping("divisions")
public class DivisionApi {

	@Autowired
	private DivisionService service;
	
	@GetMapping
	List<DivisionListItem> findAll() {
		return service.findAll();
	}
}
