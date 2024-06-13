package com.jdc.demo.constants;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = OrderAnnotation.class)
public class TransactionCheckerTest {

	@Order(1)
	@Test
	void test_before_enum() {
		StatusChecker.check(TransactionStatus.APPROVED);
		StatusChecker.check(100);
	}
	
	@Order(2)
	@Test
	void test_after_enum() {
		StatusChecker.checkEnum(TransactionState.APPLIED);
		StatusChecker.checkEnum(TransactionState.APPROVED);
	}
	
	@Order(3)
	@Test
	void test_methods_of_enum() {
		var status = TransactionState.APPLIED;
		var name = status.name();
		var ordinal = status.ordinal();
		
		System.out.println(name);
		System.out.println(ordinal);
		
		TransactionState[] states = TransactionState.values();
		for(var state : states) {
			System.out.printf("%d %s%n", state.ordinal(), state.name());
		}
		
		var parsedState = TransactionState.valueOf("CANCELED");
		System.out.println(parsedState);
	}
}
