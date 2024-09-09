package com.jdc.spring.pos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.pos.domain.exceptions.PosBusinessException;
import com.jdc.spring.pos.domain.input.ShoppingCart;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class SaleServiceTest {
	
	@Autowired
	private SaleService service;

	@Test
	@Order(1)
	void test_error_null_cart() {
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(null));
		
		assertEquals("Cart must not be null.", exception.getMessage());
	}
	
	@Test
	@Order(2)
	void test_error_empty_sale_person() {
		
		var cart = new ShoppingCart();
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart));
		
		assertEquals("Please enter sale person name.", exception.getMessage());
	}
	
	@Test
	@Order(3)
	void test_error_null_items() {
		var cart = new ShoppingCart();
		cart.setSalePerson("Thidar");
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart));
		
		assertEquals("Please enter sale items.", exception.getMessage());
	}
	
	@Test
	@Order(4)
	void test_error_null_product_code() {
		var cart = new ShoppingCart();
		cart.setSalePerson("Thidar");
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart));
		
		assertEquals("Please enter sale items.", exception.getMessage());
	}
	
}
