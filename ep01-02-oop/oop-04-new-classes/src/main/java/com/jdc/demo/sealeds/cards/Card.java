package com.jdc.demo.sealeds.cards;

public sealed interface Card permits GameCard, TarotCard{

	String name();
	int ordinal();
	int value();
}
