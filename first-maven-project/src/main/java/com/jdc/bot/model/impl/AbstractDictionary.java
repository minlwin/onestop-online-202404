package com.jdc.bot.model.impl;

import com.jdc.bot.model.Dictionary;

public abstract class AbstractDictionary implements Dictionary{

	protected int capacity;
	protected int size;

	public AbstractDictionary() {
		super();
	}

	protected int hash(String question) {
		var hash = question.hashCode() % capacity;
		return hash < 0 ? (hash * -1) : hash;
	}

}