package com.jdc.online.balances.controller.member;

import java.util.ArrayList;
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
import com.jdc.online.balances.controller.member.dto.LedgerEntryFormItem;
import com.jdc.online.balances.controller.member.dto.LedgerEntrySearch;
import com.jdc.online.balances.controller.member.dto.LedgerSelectItem;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.service.LedgerEntryService;
import com.jdc.online.balances.service.LedgerManagementService;
import com.jdc.online.balances.utils.exceptions.AppBusinessException;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member/entry/{type}")
public class MemberLedgerEntryController {
	
	private final LedgerEntryService entryService;
	private final LedgerManagementService ledgerService;
	
	@GetMapping
	String index(
			ModelMap model, 
			@PathVariable BalanceType type,
			LedgerEntrySearch search, 
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size
			) {
		
		var username = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		
		model.put("result", entryService.search(username, type, search, page, size));
		return "member/entries/list";
	}
	
	@GetMapping("create")
	String addNew(ModelMap model, 
			@PathVariable BalanceType type) {
		return "member/entries/edit";
	}
	
	@GetMapping("edit")
	String edit(@RequestParam String id) {
		return "member/entries/edit";
	}

	@PostMapping("save")
	String save(
			ModelMap model,
			@Validated @ModelAttribute(name = "form") LedgerEntryForm entryForm, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/entries/edit";
		}
		
		try {
			var id = entryService.save(entryForm);
			return "redirect:/member/balance/%s".formatted(id);
		} catch(AppBusinessException e) {
			model.put("error", e.getMessage());
			return "member/entries/edit";
		}
	}
	
	@PostMapping("item/add")
	String addItem(@ModelAttribute(name = "form") LedgerEntryForm entryForm) {
		entryForm.getItems().add(new LedgerEntryFormItem());
		return "member/entries/edit";
	}
	
	@PostMapping("item/remove")
	String removeItem(@ModelAttribute(name = "form") LedgerEntryForm entryForm) {
		
		var removedItems = entryForm.getItems().stream().filter(a -> !a.isDeleted()).toList();
		
		removedItems = new ArrayList<>(removedItems);
		
		if(removedItems.isEmpty()) {
			removedItems.add(new LedgerEntryFormItem());
		}
		
		entryForm.setItems(removedItems);
		
		return "member/entries/edit";
	}
	
	@ModelAttribute(name = "form")
	LedgerEntryForm ledgerEntryForm(
			@PathVariable BalanceType type, 
			@RequestParam(required = false) String id) {
		
		var form = new LedgerEntryForm();
		
		if(StringUtils.hasLength(id)) {
			form = entryService.findForEdit(id);
		}
		
		if(null == form.getItems() || form.getItems().isEmpty()) {
			form.getItems().add(new LedgerEntryFormItem());
		}
		
		return form;
	}
	
	@ModelAttribute(name = "ledgers")
	List<LedgerSelectItem> getLedgers(@PathVariable BalanceType type) {
		var username = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		return ledgerService.findForEntry(username, type);
	}
	
	@ModelAttribute(name = "urlType")
	String getType(@PathVariable BalanceType type) {
		return type.name().toLowerCase();
	}
}
