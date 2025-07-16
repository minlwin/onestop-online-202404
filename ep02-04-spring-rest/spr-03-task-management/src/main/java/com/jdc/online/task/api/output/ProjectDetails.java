package com.jdc.online.task.api.output;

import java.time.LocalDate;
import java.util.List;

public record ProjectDetails(
		int id,
		String name,
		LocalDate startDate,
		LocalDate dueDate,
		String details,
		List<TaskListItem> tasks) {

}
