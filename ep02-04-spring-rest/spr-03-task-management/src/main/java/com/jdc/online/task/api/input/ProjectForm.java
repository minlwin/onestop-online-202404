package com.jdc.online.task.api.input;

import java.time.LocalDate;

import com.jdc.online.task.model.entity.Project;

public record ProjectForm(
		String name,
		LocalDate startDate,
		LocalDate dueDate,
		String description) {

	public Project entity() {
		
		var entity = new Project();
		update(entity);
		return entity;
	}

	public void update(Project entity) {
		entity.setName(name);
		entity.setStartDate(startDate);
		entity.setDueDate(dueDate);
		entity.setDescription(description);
	}

}
