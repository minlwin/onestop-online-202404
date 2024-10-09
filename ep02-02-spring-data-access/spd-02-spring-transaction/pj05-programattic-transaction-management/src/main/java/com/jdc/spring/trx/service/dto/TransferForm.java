package com.jdc.spring.trx.service.dto;

public record TransferForm(
		String from,
		String to,
		int amount,
		String particular) {

}
