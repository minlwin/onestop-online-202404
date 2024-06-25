package com.jdc.pattern.domain;

public sealed interface TransactionType 
	permits TransactionTypeForCashOut, TransactionTypeForTransfer{

	String name();
}
