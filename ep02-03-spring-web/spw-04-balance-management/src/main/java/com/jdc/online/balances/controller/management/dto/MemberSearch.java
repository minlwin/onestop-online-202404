package com.jdc.online.balances.controller.management.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberSearch {

	private Boolean status;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String name;
}
