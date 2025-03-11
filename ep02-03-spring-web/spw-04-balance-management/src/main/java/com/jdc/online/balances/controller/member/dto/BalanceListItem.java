package com.jdc.online.balances.controller.member.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BalanceListItem(
		String code,
		LocalDateTime issueAt,
		String ledgerName,
		String particular,
		BigDecimal income,
		BigDecimal expense,
		BigDecimal balance) {

}
