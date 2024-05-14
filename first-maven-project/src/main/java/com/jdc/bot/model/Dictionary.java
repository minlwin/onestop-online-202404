package com.jdc.bot.model;

public interface Dictionary {

	int register(String question, String answer);

	String search(String question);

	public static record Entry(String question, String answer) {}

	
}