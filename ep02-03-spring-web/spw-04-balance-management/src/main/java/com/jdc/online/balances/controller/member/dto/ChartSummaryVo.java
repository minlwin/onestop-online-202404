package com.jdc.online.balances.controller.member.dto;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Summary Data
 */
public record ChartSummaryVo(
		BigDecimal incomes,
		BigDecimal expenses) {

	public BigDecimal getBalances() {
		return Optional.ofNullable(incomes).orElse(BigDecimal.ZERO)
				.subtract(Optional.ofNullable(expenses).orElse(BigDecimal.ZERO));
	}
}
