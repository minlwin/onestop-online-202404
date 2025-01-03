package com.jdc.spring.mvc.controller;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("returns")
public class ReturnTypesController {
	
	// String -> Logical View Name
	// URL /returns/handler1
	@GetMapping("handler1")
	String handle(Model model) {
		model.addAttribute("message", "Message form Logical View Name Return Method.");
		return "returns/view1";
	}
	
	// ModelAndView
	// URL /returns/handler2
	@GetMapping("handler2")
	ModelAndView modelAndView() {
		var mv = new ModelAndView("returns/view2");
		mv.getModelMap().put("days", DayOfWeek.values());
		mv.getModelMap().put("message", "Message from Model And View Created in Handler Method");
		return mv;
	}

	// Void
	// URL /returns/handler3
	@GetMapping("handler3")
	void index(ModelMap model) {
		model.put("message", "Message from Void Returns Handler Method.");
	}
	
	@GetMapping("handler4")
	String redirect() {
		return "redirect:/returns/handler1";
	}
	
}
