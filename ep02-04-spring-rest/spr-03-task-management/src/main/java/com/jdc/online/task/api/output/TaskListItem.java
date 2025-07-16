package com.jdc.online.task.api.output;

import java.time.LocalDate;

public record TaskListItem(
		int id,
		int projectId,
		String project,
		String name,
		String assignee,
		LocalDate duedate,
		LocalDate startDate,
		LocalDate endDate) {

}
