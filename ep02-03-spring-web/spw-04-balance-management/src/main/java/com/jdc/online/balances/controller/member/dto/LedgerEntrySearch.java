package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LedgerEntrySearch {

	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String keyword;
}
