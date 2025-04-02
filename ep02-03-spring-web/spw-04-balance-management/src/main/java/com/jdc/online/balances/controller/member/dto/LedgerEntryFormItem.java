package com.jdc.online.balances.controller.member.dto;

import java.math.BigDecimal;

import com.jdc.online.balances.model.entity.LedgerEntryItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LedgerEntryFormItem {

	@NotBlank(message = "Please enter item name.")
	private String itemName;
	
	@NotNull(message = "Please enter unit price.")
	private BigDecimal unitPrice = BigDecimal.ZERO;
	
	@NotNull(message = "Please enter quantity.")
	private Integer quantity = 0;
	
	private boolean deleted;
	
	public static LedgerEntryFormItem from(LedgerEntryItem entity) {
		
		var item = new LedgerEntryFormItem();
		
		item.setItemName(entity.getItem());
		item.setUnitPrice(entity.getUnitPrice());
		item.setQuantity(entity.getQuantity());
		
		return item;
	}
}
