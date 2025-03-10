package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDate;

import com.jdc.online.balances.model.entity.consts.BalanceType;

import lombok.Data;

@Data
public class LedgerEntrySearch {

	private BalanceType type;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String keyword;
}
