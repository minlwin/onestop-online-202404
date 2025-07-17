package com.jdc.online.task.api.output;

import java.time.LocalDate;

import com.jdc.online.task.model.entity.Tasks;

public record TaskDetails(
		int id,
		ProjectListItem project,
		String name,
		String assignee,
		LocalDate duedate,
		LocalDate startDate,
		LocalDate endDate,
		String description) {

	public static TaskDetails from(Tasks entity) {
		return new TaskDetails(
				entity.getId(), 
				ProjectListItem.from(entity.getProject()), 
				entity.getName(), 
				entity.getAssignee(), 
				entity.getDueDate(), 
				entity.getStartDate(), 
				entity.getEndDate(), 
				entity.getDescription());
	}

}
