package com.jdc.online.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BalanceCheckerTest {

	
	private BalanceChecker checker;
	
	@BeforeEach
	void beforeEach() {
		checker = new BalanceChecker();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
		"[]",
		"()",
		"{}",
		"[({})]",
		"[](){}",
		"()[()]"
	})
	void test_is_balanced(String value) {
		assertTrue(checker.isBalance(value));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
		"[",
		"(]",
		"{}}",
		")[({})]",
		"{{}"
	})
	void test_is_not_balance(String value) {
		assertFalse(checker.isBalance(value));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"",
			"( )",
			"1{}"
		})
	void test_has_thrown_exception(String value) {
		assertThrows(IllegalArgumentException.class, () -> checker.isBalance(value));
	}
}
