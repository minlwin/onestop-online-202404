package com.jdc.online.balances.controller.member;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
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
import com.jdc.online.balances.controller.member.dto.LedgerSelectItem;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.service.LedgerEntryService;
import com.jdc.online.balances.service.LedgerManagementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member/entry")
public class MemberLedgerEntryController {
	
	private final LedgerEntryService entryService;
	private final LedgerManagementService ledgerService;
	
	@GetMapping("{type}")
	String index(
			ModelMap model, 
			@PathVariable BalanceType type,
			LedgerEntrySearch search, 
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size
			) {
		
		var username = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		
		model.put("result", entryService.search(username, type, search));
		return "member/entries/list";
	}
	
	@GetMapping("{type}/add-new")
	String addNew(ModelMap model, 
			@PathVariable BalanceType type) {
		return "member/entries/edit";
	}
	
	@GetMapping("{type}/edit/{id}")
	String edit(@PathVariable String id) {
		return "member/entries/edit";
	}

	@PostMapping("{type}/save")
	String save(
			@Validated @ModelAttribute(name = "form") LedgerEntryForm entryForm, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/entries/edit";
		}
		
		return "redirect:/member/balance/20250301-001";
	}
	
	@PostMapping("{type}/save/add-item")
	String addItem(@ModelAttribute(name = "form") LedgerEntryForm entryForm) {
		return "member/entries/edit";
	}
	
	@PostMapping("{type}/save/remove-item")
	String removeItem(@ModelAttribute(name = "form") LedgerEntryForm entryForm) {
		return "member/entries/edit";
	}
	
	@ModelAttribute(name = "form")
	LedgerEntryForm ledgerEntryForm(
			@PathVariable BalanceType type, 
			@PathVariable(required = false) String id) {
		
		if(StringUtils.hasLength(id)) {
			return entryService.findForEdit(id);
		}
		
		return new LedgerEntryForm();
	}
	
	@ModelAttribute(name = "ledgers")
	List<LedgerSelectItem> getLedgers(@PathVariable BalanceType type) {
		var username = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		return ledgerService.findForEntry(username, type);
	}
}
