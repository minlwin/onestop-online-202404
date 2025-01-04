package com.jdc.spring.mvc.controller.input;

import java.time.DayOfWeek;
import java.time.LocalDate;

import lombok.Data;

@Data
public class JavaBean {

	private DayOfWeek day;
	private Integer value;
	private LocalDate date;
}
