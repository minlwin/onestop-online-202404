package com.jdc.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.online.balances.controller.member.dto.LedgerEntryForm;
import com.jdc.online.balances.controller.member.dto.LedgerEntrySearch;
import com.jdc.online.balances.model.entity.consts.BalanceType;

@Controller
@RequestMapping("member/entry")
public class MemberLedgerEntryController {
	
	@GetMapping("{type}")
	String index(
			ModelMap model, 
			@PathVariable BalanceType type,
			LedgerEntrySearch search, 
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size
			) {
		
		return "member/entries/list";
	}
	
	@GetMapping("add-new/{type}")
	String addNew(ModelMap model, 
			@PathVariable BalanceType type) {
		return "member/entries/edit";
	}
	
	@GetMapping("edit/{id}")
	String edit(@PathVariable String id) {
		return "member/entries/edit";
	}

	@PostMapping("save")
	String save(
			@Validated @ModelAttribute(name = "form") LedgerEntryForm entryForm, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/entries/edit";
		}
		
		return "redirect:/member/balance/20250301-001";
	}
	
	@PostMapping("save/add-item")
	String addItem(@ModelAttribute(name = "form") LedgerEntryForm entryForm) {
		return "member/entries/edit";
	}
	
	@PostMapping("save/remove-item")
	String removeItem(@ModelAttribute(name = "form") LedgerEntryForm entryForm) {
		return "member/entries/edit";
	}
}
