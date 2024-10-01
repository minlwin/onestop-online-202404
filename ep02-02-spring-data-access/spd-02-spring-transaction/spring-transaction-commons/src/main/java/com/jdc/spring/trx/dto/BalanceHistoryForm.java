package com.jdc.spring.trx.dto;

public record BalanceHistoryForm(
		String accountNum,
		int version,
		int lastAmount,
		int trxId,
		boolean credit,
		int amount,
		String remark) {

}
