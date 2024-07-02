package com.jdc.online.pos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.online.pos.model.input.ProductForm;

@TestMethodOrder(value = OrderAnnotation.class)
public class ProductModelTest {

	private static ProductModel model;
	
	@BeforeAll
	static void init() {
		model = ProductModel.getInstance();
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		",500,Please enter product name.,",
		"Coke,90,Please enter price with min 100.,",
		",90,Please enter product name.,Please enter price with min 100."
	})
	void test_product_add_error(String name, int price, String message1, String message2) {
		
		var form = new ProductForm(name, price);
		
		var exception = assertThrows(ValidationException.class, () -> {
			model.create(form);
		});
		
		var messages = exception.getMessages();
		
		if(messages.length >= 1) {
			assertEquals(message1, messages[0]);
		}
		
		if(messages.length >= 2) {
			assertEquals(message2, messages[1]);
		}
		
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"Coke,100,1",
		"Potato Chips,100,2"
	})
	void test_product_success(String name, int price, int expecedId) {
		
		var form = new ProductForm(name, price);
		var id = model.create(form);
		
		assertEquals(expecedId, id);
	}
}
