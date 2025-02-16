package com.jdc.spring.controller.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {

	private List<TaskDto> tasks;
	
	public TaskRepository() {
		tasks = Collections.synchronizedList(new ArrayList<>());
	}
	
	@PreFilter("hasRole('MANAGER') or (hasRole('STAFF') and filterObject.owner eq authentication.name)")
	public void add(List<TaskDto> dto) {
		tasks.addAll(dto);
	}
	
	@PreFilter("hasRole('MANAGER') or (hasRole('STAFF') and filterObject.owner eq authentication.name)")
	public List<TaskDto> getAll() {
		return new ArrayList<>(tasks);
	}
}
