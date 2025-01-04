package com.jdc.spring.mvc.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.spring.mvc.controller.input.JavaBean;
import com.jdc.spring.mvc.controller.input.Record;

@Controller
@RequestMapping("inputs")
public class InputValueController {

	// Request Param
	// GET /inputs?day=MONDAY
	@GetMapping
	String queryParams(
			@RequestParam(required = false, name = "day") DayOfWeek dayOfWeek, 
			@RequestParam(required = false, defaultValue = "0") int value,
			@RequestParam(required = false) LocalDate date, 
			ModelMap model) {
		// var day = req.getParameter("day");
		// var dayOfWeek = DayOfWeek.valueOf(day);
		model.put("day", dayOfWeek);
		model.put("count", value);
		model.put("date", date);
		
		return "inputs/view1";
	}
	
	// GET /inputs/javabean
	@GetMapping("javabean")
	String loadJavaBean(ModelMap model) {
		model.put("days", DayOfWeek.values());
		return "inputs/view2";
	}
	
	// Request Param -> Java Bean Object
	// GET /inputs/get/form
	@GetMapping("get/form")
	String javaBean(JavaBean bean, ModelMap model) {
		
		model.put("day", bean.getDay());
		model.put("count", bean.getValue());
		model.put("date", bean.getDate());

		return "inputs/view1";
	}
	
	// GET /inputs/javabean
	@GetMapping("record")
	String loadRecord(ModelMap model) {
		model.put("days", DayOfWeek.values());
		return "inputs/view3";
	}
	
	// POST /inputs
	// Request Param -> Record Object
	@PostMapping
	String records(Record bean, ModelMap model) {
		model.put("day", bean.day());
		model.put("count", bean.value());
		model.put("date", bean.date());
		return "inputs/view1";
	}
	
	@GetMapping("path/{id}")
	String pathVariable(@PathVariable int id, ModelMap model) {
		model.put("message", "Path variable is %d".formatted(id));
		return "inputs/view4";
	}
}
