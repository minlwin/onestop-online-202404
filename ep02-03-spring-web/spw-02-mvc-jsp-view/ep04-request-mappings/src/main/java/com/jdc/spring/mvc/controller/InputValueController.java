package com.jdc.spring.mvc.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("inputs")
public class InputValueController {

	// Request Param
	// GET /inputs?day=MONDAY
	@GetMapping
	String queryParams(
			@RequestParam(required = false, name = "day") DayOfWeek dayOfWeek, 
			@RequestParam(required = false, defaultValue = "0") int value,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, 
			ModelMap model) {
		// var day = req.getParameter("day");
		// var dayOfWeek = DayOfWeek.valueOf(day);
		model.put("day", dayOfWeek);
		model.put("count", value);
		model.put("date", date);
		
		return "inputs/view1";
	}
}
