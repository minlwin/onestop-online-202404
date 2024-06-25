package com.jdc.pattern.domain;

public record TransactionTypeForCashOut(
		String name,
		String consumerName,
		String agentShop) implements TransactionType{

}
