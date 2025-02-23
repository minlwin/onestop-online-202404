package com.jdc.online.balances.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping
	String dummySignIn(@RequestParam String username, @RequestParam String password) {
		return "redirect:/%s/home".formatted(password);
	}
}
