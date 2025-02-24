package com.jdc.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.online.balances.model.entity.consts.BalanceType;

@Controller
@RequestMapping("member/entry")
public class MemberLedgerEntryController {

	@GetMapping("{type}")
	String index(@PathVariable String type, 
			ModelMap model) {
		
		model.put("type", BalanceType.from(type));
		
		return "member/entries/list";
	}

}
