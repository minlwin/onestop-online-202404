package com.jdc.online.balances.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({
	"/",
	"/signin"
})
public class HomeController {

	@GetMapping
	String index() {
		return "anonymous/signin";
	}
}
