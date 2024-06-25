package com.jdc.pattern.domain;

public sealed abstract class AbstractTransaction implements Transaction permits AgentTransaction, ConsumerTransaction{

	private long id;
	private String name;
	
	public AbstractTransaction(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public long getTransactionId() {
		return id;
	}
	
	@Override
	public String getTransactionName() {
		return name;
	}
}
