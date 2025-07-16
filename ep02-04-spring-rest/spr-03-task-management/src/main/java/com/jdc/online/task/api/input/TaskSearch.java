package com.jdc.online.task.api.input;

import java.time.LocalDate;

public record TaskSearch(
		Integer projectId,
		LocalDate dueDateFrom,
		LocalDate dueDateTp,
		LocalDate startFrom,
		LocalDate startTo,
		LocalDate endFrom,
		LocalDate endTo,
		String keyword) {

}
