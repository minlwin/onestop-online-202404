package com.jdc.pattern.domain;

public record TransactionTypeForTransfer(
		String name,
		String transferFrom,
		String transferTo) implements TransactionType{

}
