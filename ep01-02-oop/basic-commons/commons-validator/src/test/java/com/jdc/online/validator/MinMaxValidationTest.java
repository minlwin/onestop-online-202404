package com.jdc.online.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.online.validator.domain.Numbers;

public class MinMaxValidationTest {

	private Validator validator = Validator.getInstance();
	
	@ParameterizedTest
	@CsvSource({
		"10,10,10,10",
		"100,100,100,100"
	})
	void test_success(byte v1, short v2, int v3, long v4) {
		
		var input = new Numbers(v1, v2, v3, v4);
		
		var result = validator.validate(input);
		
		assertFalse(result.hasErrors());
	}
	
	@ParameterizedTest
	@CsvSource({
		"9,9,9,9",
		"101,101,101,101"
	})
	void test_fails(byte v1, short v2, int v3, long v4) {

		var input = new Numbers(v1, v2, v3, v4);
		
		var result = validator.validate(input);
		
		assertTrue(result.hasErrors());
		
		assertEquals(4, result.getErrors().length);
	}
}
