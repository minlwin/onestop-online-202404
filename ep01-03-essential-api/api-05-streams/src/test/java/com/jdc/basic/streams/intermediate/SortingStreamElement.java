package com.jdc.basic.streams.intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class SortingStreamElement {

	@Test
	void test_sort_integer() {
		
		var random = ThreadLocalRandom.current();
		
		var list = Stream.generate(() -> random.nextInt(1, 100))
			.limit(10)
			.peek(data -> System.out.printf("Before -> %d%n", data))
			.sorted()
			.peek(data -> System.out.printf("After -> %d%n", data))
			.toList();
		
		System.out.println(list);
	}
	
	@Test
	void test_sort_custom_object() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			var list = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.sorted((a, b) -> a.name().compareTo(b.name()))
				.toList();
			
			System.out.println(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
