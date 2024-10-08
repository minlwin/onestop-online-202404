package com.jdc.spring.trx.dto;

public record AccountInfo(
		String accountNum,
		String accountName,
		String phone,
		int amount,
		int version) {

	public int nextVersion() {
		return version + 1;
	}

}
