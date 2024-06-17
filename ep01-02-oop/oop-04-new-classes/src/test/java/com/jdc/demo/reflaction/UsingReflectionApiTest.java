package com.jdc.demo.reflaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.demo.reflection.Product;
import com.jdc.demo.reflection.UsingReflectionApi;

public class UsingReflectionApiTest {

	private UsingReflectionApi usingApi;
	
	@BeforeEach
	void beforeEach() {
		usingApi = new UsingReflectionApi();
	}
	
	@Test
	void test_show_fields() {
		usingApi.showFields(new Product());
	}
	
	@Test
	void test_show_methods() {
		usingApi.showMethods(new Product());
	}
	
	@Test
	void test_get_product() {
		var product = usingApi.getProduct();
		assertNotNull(product);
	}
	
	@ParameterizedTest
	@CsvSource("1,Coke,700")
	void test_set_value(int id, String name, int price) {
		var product = new Product();
		
		usingApi.setValue(product, id, name, price);
		
		assertEquals(id, product.getId());
		assertEquals(name, product.getName());
		assertEquals(price, product.getPrice());
	}
}
