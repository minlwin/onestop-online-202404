package com.jdc.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.online.balances.controller.member.dto.BalanceSearch;

@Controller
@RequestMapping("member/balance")
public class MemberReportForBalanceController {

	@GetMapping
	String index(
			ModelMap model,
			BalanceSearch search, 
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		return "member/balance/list";
	}

	// ID (yyyyMMdd-000)
	@GetMapping("{id}")
	String findById(@PathVariable String id, ModelMap model) {
		return "member/balance/details";
	}
}
