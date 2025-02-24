package com.jdc.online.balances.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/access")
public class MemberAccessController {

	@GetMapping
	String search() {
		return "management/access/list";
	}
}
