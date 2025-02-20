package com.jdc.spring.controller.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

@Repository
@ApplicationScope
public class TaskRepository {

	private Set<TaskDto> tasks;
	
	public TaskRepository() {
		tasks = Collections.synchronizedSet(new LinkedHashSet<>());
	}
	
	@PreFilter("hasRole('MANAGER') or (hasRole('STAFF') and filterObject.owner eq authentication.name)")
	public void add(List<TaskDto> dto) {
		tasks.addAll(dto);
	}
	
	@PostFilter("hasRole('MANAGER') or (hasRole('STAFF') and filterObject.owner eq authentication.name)")
	public List<TaskDto> getAll() {
		return new ArrayList<>(tasks);
	}
}
