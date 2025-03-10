package com.jdc.online.balances.controller.member.dto;

import java.math.BigDecimal;

public record LedgerEntryDetailsItem(
		String itemName,
		BigDecimal unitPrice,
		int quantity) {

}
