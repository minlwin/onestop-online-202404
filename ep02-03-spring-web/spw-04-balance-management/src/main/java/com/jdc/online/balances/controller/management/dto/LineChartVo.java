package com.jdc.online.balances.controller.management.dto;

import java.time.LocalDate;

public record LineChartVo(
		LocalDate date,
		Long value) {

}
