package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDate;

import com.jdc.online.balances.model.entity.consts.AccessStatus;

import lombok.Data;

@Data
public class AccessHistorySearch {

	private AccessStatus status;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String keyword;
}
