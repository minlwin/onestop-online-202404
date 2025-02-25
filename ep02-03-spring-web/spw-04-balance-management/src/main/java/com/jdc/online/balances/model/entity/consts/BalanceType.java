package com.jdc.online.balances.model.entity.consts;

public enum BalanceType {
	Incomes, Expenses;
	
	public static BalanceType from(String value) {
		return switch (value.toLowerCase()) {
		case "incomes" -> Incomes;
		case "expenses" -> Expenses;
		default -> throw new IllegalArgumentException("Invalid balance type value.");
		};
	}
}
