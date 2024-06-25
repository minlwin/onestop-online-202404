package com.jdc.pattern.domain;

public sealed interface Transaction permits AbstractTransaction{

	long getTransactionId();
	String getTransactionName();
}
