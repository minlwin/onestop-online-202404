package com.jdc.basic.streams.intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Product;

public class MappingElements {

	@Test
	void test_map() {
		
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			var list = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.toList();
			
			System.out.println(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_flat_map() {
		try(var stream1 = Files.lines(Path.of("data", "product", "product1.txt"));
				var stream2 = Files.lines(Path.of("data", "product", "product2.txt"))) {
			
			var list = Stream.of(stream1, stream2)
					.flatMap(stream -> stream)
					.map(line -> line.split("\t"))
					.map(Product::from)	
					.toList();
			
			System.out.println(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_map_multi() {
		try(var stream = Files.lines(Path.of("data", "product", "product1.txt"))) {
			
			var list = stream.map(line -> line.split("\t"))
				.map(Product::from)	
				.mapMulti((Product p, Consumer<String> consumer) -> {
					if(p.price() > 10) {
						consumer.accept(p.name());
					}
				})
				.toList();
			
			System.out.println(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
