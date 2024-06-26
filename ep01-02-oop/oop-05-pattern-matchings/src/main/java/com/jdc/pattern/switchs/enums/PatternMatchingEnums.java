package com.jdc.pattern.switchs.enums;

public class PatternMatchingEnums {

	public int getLevel(Card card) {
		return switch(card) {
		case GameCard.Spade, TarotCard.Aingel -> 1;
		case GameCard.Heart, TarotCard.Saint -> 2;
		case GameCard.Diamond, TarotCard.People -> 3;
		case GameCard.Clover, TarotCard.Daemon -> 4;
		default -> throw new IllegalArgumentException();
		};
	}
}
