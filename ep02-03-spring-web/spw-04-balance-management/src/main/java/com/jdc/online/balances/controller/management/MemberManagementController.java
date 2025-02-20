package com.jdc.online.balances.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/member")
public class MemberManagementController {

	@GetMapping
	String index() {
		return "";
	}

}
