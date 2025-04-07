package com.jdc.online.balances.controller.member.dto;

import java.math.BigDecimal;

import com.jdc.online.balances.model.entity.LedgerEntryItem;

public record LedgerEntryDetailsItem(
		String itemName,
		BigDecimal unitPrice,
		int quantity) {
	
	public BigDecimal getTotal() {
		return unitPrice.multiply(BigDecimal.valueOf(quantity));
	}

	public static LedgerEntryDetailsItem from(LedgerEntryItem entity) {
		return new LedgerEntryDetailsItem(entity.getItem(), entity.getUnitPrice(), entity.getQuantity());
	}
}
