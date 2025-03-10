package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BalanceSearch {

	private LocalDate dateFrom;
	private LocalDate dateTo;
}
