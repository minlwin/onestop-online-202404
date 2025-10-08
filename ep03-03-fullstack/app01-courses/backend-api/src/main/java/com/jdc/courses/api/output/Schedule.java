package com.jdc.courses.api.output;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

public record Schedule(
		@NotNull(message = "Please select schedule day.")
		DayOfWeek day,
		@NotNull(message = "Please select schedule start time.")
		LocalTime start,
		@NotNull(message = "Please select schedule end time.")
		LocalTime end) {

}
