package com.jdc.basic.streams.terminal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class GetMultipleResult {

	@Test
	void test_to_array() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			Object[] array = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.toArray();
			
			assertNotNull(array);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_to_generic_array() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			Product[] array = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.toArray(size -> new Product[size]);
			
			assertNotNull(array);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
