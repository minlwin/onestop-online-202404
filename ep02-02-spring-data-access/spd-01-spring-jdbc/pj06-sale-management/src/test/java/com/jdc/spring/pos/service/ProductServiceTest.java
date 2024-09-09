package com.jdc.spring.pos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.pos.domain.exceptions.PosBusinessException;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService service;
	
	@Test
	void test_error_no_code() {
		var exception = assertThrows(
				PosBusinessException.class, 
				() -> service.findByCode(null));
		
		assertEquals("Please enter product code.", exception.getMessage());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"p0001", "P0011", "P0007"})
	void test_error_inivalid_code(String code) {
		var exception = assertThrows(
				PosBusinessException.class, 
				() -> service.findByCode(code));
		
		assertEquals("Invalid product code.", exception.getMessage());
	}
	
	@ParameterizedTest
	@CsvSource({
		"P0001,Egg L Size,500",
		"P0002,Egg M Size,400",
		"P0003,Egg S Size,350",
		"P0004,Potato Chips,1200",
		"P0005,Coke 350 ML,800",
		"P0006,Coke 500 ML,1500"
	})
	void test_found(String code, String name, int price) {
		
		var result = service.findByCode(code);
		assertNotNull(result);
		
		assertEquals(code, result.getCode());
		assertEquals(name, result.getName());
		assertEquals(price, result.getPrice());
	}
}
