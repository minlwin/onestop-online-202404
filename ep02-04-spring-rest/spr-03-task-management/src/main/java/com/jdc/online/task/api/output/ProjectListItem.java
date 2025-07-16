package com.jdc.online.task.api.output;

import java.time.LocalDate;

public record ProjectListItem(
		int id,
		String name,
		LocalDate startDate,
		LocalDate dueDate,
		long tasks) {

}
