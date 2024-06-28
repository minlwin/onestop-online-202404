package com.jdc.pattern.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.pattern.switchs.enums.CardValue;
import com.jdc.pattern.switchs.enums.GameCard;
import com.jdc.pattern.switchs.enums.GuardedPatternDemo;

public class GuardedPatternTest {

	@ParameterizedTest
	@CsvSource({
		"Heart,10",
		"Heart,1",
		"Spade,10",
		"Spade,1",
	})
	void test(GameCard card, int value) {
		var v1 = new CardValue<GameCard>(card, value);
		var result1 = GuardedPatternDemo.getLabel(v1);
		System.out.println(result1);
	}
}
