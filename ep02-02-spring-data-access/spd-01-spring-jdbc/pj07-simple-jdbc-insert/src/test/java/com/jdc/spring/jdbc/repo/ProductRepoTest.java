package com.jdc.spring.jdbc.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jdc.spring.jdbc.domain.ProductDetails;
import com.jdc.spring.jdbc.domain.ProductForm;

@SpringBootTest
@ActiveProfiles("simpleJdbcInsert")
@TestMethodOrder(value = OrderAnnotation.class)
public class ProductRepoTest {
	
	@Autowired
	private ProductRepo repo;
	
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_insert.txt", delimiter = '\t' )
	void test_insert(int id, 
			@AggregateWith(value = ProductFormAggregator.class) ProductForm form) {
		
		var result = repo.create(form);
		assertEquals(id, result);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvFileSource(resources = "/test_insert.txt", delimiter = '\t' )
	void test_find_by_id_found(int id, 
			@AggregateWith(value = ProductDetailsAggregator.class) ProductDetails details) {
		var result = repo.findById(id);
		assertEquals(details, result);
	}
	
	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = {
		0, 7	
	})
	void test_find_by_id_not_found(int id) {
		assertNull(repo.findById(id));
	}
}
