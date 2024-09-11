package com.jdc.spring.pos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.pos.domain.exceptions.PosBusinessException;
import com.jdc.spring.pos.domain.input.ShoppingCart;
import com.jdc.spring.pos.service.data.ErrorForSaleItemProvider;
import com.jdc.spring.pos.service.data.SaleServiceCreateSuccess;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class SaleServiceTest {
	
	@Autowired
	private SaleService service;

	@Order(1)
	@NullSource
	@ParameterizedTest
	void test_error_null_cart(ShoppingCart cart) {
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(null));
		
		assertEquals("Cart must not be null.", exception.getMessage());
	}
	
	@Order(2)
	@MethodSource
	@ParameterizedTest
	void test_error_empty_sale_person(ShoppingCart cart) {
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart));
		
		assertEquals("Please enter sale person name.", exception.getMessage());
	}
	
	static List<ShoppingCart> test_error_empty_sale_person() {
		return List.of(new ShoppingCart());
	}
	
	@Order(3)
	@MethodSource
	@ParameterizedTest
	void test_error_null_items(ShoppingCart cart) {
		
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart));
		
		assertEquals("Please enter sale items.", exception.getMessage());
	}
	
	static List<ShoppingCart> test_error_null_items() {
		return List.of(ShoppingCart.withName("Aung Aung"));
	}
	
	@Order(4)
	@ParameterizedTest
	@ArgumentsSource(value = ErrorForSaleItemProvider.class)
	void test_error_for_sale_item(ShoppingCart cart, String message) {
		var exception = assertThrows(PosBusinessException.class, 
				() -> service.checkOut(cart));
		assertEquals(message, exception.getMessage());
	}
	
	@Order(5)
	@ParameterizedTest
	@ArgumentsSource(value = SaleServiceCreateSuccess.class)
	void test_create_success(ShoppingCart cart, int id) {
		var result = service.checkOut(cart);
		assertEquals(id, result);
	}
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = {0, 4})
	void test_find_by_id_notfound(int id) {
		
		var ex = assertThrows(PosBusinessException.class, 
				() -> service.findById(id));
		
		assertEquals("Invalid sale id.", ex.getMessage());
	}
	
}
