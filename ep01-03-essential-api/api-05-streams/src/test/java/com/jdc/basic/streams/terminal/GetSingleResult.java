package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class GetSingleResult {
	
	@Test
	void test_max() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			var max = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.max((a, b) -> a.price() - b.price());
			
			max.ifPresent(product -> System.out.println(product));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test_min() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			var min = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.min((a, b) -> a.price() - b.price());
			
			min.ifPresent(product -> System.out.println(product));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_find_first() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			var min = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.findFirst();
			
			min.ifPresent(product -> System.out.println(product));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
