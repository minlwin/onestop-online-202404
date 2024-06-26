package com.jdc.pattern.switchs.enums;

public class GuardedPatternDemo {

	public static String getLabel(CardValue<GameCard> cardValue) {
		return switch(cardValue) {
		case CardValue(var card, var value) when value == 1 && card == GameCard.Spade -> "Best Card";
		case CardValue(var card, var value) when value == 1 -> "Best value for %s".formatted(card);
		case CardValue(var card, var value) when value <= 13 -> "%s %d".formatted(card, value);
		default -> throw new IllegalArgumentException();
		};
	}

}
