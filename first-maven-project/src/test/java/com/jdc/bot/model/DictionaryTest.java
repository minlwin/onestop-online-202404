package com.jdc.bot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(value = OrderAnnotation.class)
public class DictionaryTest {
	

	private static Dictionary dict = new Dictionary(10);
	
	@Order(1)
	@ParameterizedTest
	@CsvSource(value = {
		"How are you\tI am fine, thank you.\t1",
		"Hi\tHello\t2",
		"How old are you\tI am just a child.\t3",
		"Do you like movie\tYes I like it.\t4",
		"Do you like ice cream\tThis is not my choice\t5",
		"Where do you live\tIn your heart.\t6",
		"What is your name\tMr Bot.\t7",
		"Which color do you like\tI like blue.\t8",
		"Bye!\tBye Bye, thank you.\t9",
		"Take care!\tThank you.\t10",
	}, delimiter = '\t')
	void test_register(String question, String answer, int size) {
		int result = dict.register(question, answer);
		assertEquals(size, result);
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource(value = {
		"How are you\tI am fine, thank you.",
		"Hi\tHello",
		"How old are you\tI am just a child.",
		"Do you like movie\tYes I like it.",
		"Do you like ice cream\tThis is not my choice",
		"Where do you live\tIn your heart.",
		"What is your name\tMr Bot.",
		"Which color do you like\tI like blue.",
		"Bye!\tBye Bye, thank you.",
		"Take care!\tThank you.",
	}, delimiter = '\t')
	void test_search(String question, String answer) {
		
		String result = dict.search(question);
		assertEquals(answer, result);
	}
	
	@Order(3)
	@ParameterizedTest
	@ValueSource(strings = {
		"Who is precident of UN",
		"Who is your lover"
	})
	void test_search_not_found(String question) {		
		String result = dict.search(question);
		assertNull(result);
	}
	
}
