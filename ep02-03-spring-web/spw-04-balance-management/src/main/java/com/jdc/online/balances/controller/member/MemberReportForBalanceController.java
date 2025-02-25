package com.jdc.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/balance")
public class MemberReportForBalanceController {

	@GetMapping
	String index() {
		return "member/balance/list";
	}

	// ID (yyyyMMdd-000)
	@GetMapping("{id}")
	String findById(@PathVariable String id) {
		return "member/balance/details";
	}
}
