package com.jdc.spring.trx.dto;

public record AmountUpdateForm(
		String accountNum,
		int amount, 
		int version) {

}
