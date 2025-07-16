package com.jdc.online.task.api.input;

import java.time.LocalDate;

import com.jdc.online.task.model.entity.Project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectForm(
		@NotBlank(message = "Please enter project name")
		String name,
		@NotNull(message = "Please enter start date")
		LocalDate startDate,
		@NotNull(message = "Please enter due date")
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
