package com.jdc.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/home")
public class MemberHomeController {

	@GetMapping
	String index() {
		return "";
	}

}
