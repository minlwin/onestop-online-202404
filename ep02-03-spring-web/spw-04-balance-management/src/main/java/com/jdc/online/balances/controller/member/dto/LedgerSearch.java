package com.jdc.online.balances.controller.member.dto;

import com.jdc.online.balances.model.entity.consts.BalanceType;

import lombok.Data;

@Data
public class LedgerSearch {

	private BalanceType type;
	private String keyword;
}
