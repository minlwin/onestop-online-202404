package com.jdc.online.balances.controller.member.dto;

import java.util.ArrayList;
import java.util.List;

import com.jdc.online.balances.model.entity.LedgerEntry;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LedgerEntryForm {
	
	private String id;

	@NotNull(message = "Please select leger.")
	private Integer ledgerId;
	@NotBlank(message = "Please enter particular.")
	private String particular;
	
	@NotEmpty(message = "Please enter entry items.")
	private List<@Valid LedgerEntryFormItem> items = new ArrayList<>();
	
	public static LedgerEntryForm from(LedgerEntry entity) {
		
		var form = new LedgerEntryForm();
		
		form.setId(entity.getId().getCode());
		form.setLedgerId(entity.getLedger().getId());
		form.setParticular(entity.getParticular());
		var items = entity.getItems()
				.stream().map(LedgerEntryFormItem::from).toList();
		form.setItems(new ArrayList<>(items));
		
		return form;
	}
}
