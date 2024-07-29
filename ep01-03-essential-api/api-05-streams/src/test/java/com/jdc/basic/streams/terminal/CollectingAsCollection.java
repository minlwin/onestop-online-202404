package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class CollectingAsCollection {

	
	@Test
	void test_to_list() {
		
		var stream = Stream.iterate(1, a -> a + 1)
				.limit(10);
		
		var result = stream.collect(
				() -> new ArrayList<Integer>(),  			// supplier
				(list, element) -> list.add(element), 		// accumulator
				(first, second) -> first.addAll(second));	// combiner
		
		System.out.println(result);	
	}
	
	@Test
	void test_to_list_with_collector() {
		
		var stream = Stream.iterate(1, a -> a + 1)
				.limit(10);
		
		var result = stream.collect(Collectors.toList());
		
		System.out.println(result);
		
	}
	
	@Test
	void test_to_map() {
		
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {
			
			Map<Integer, String> result = stream.map(line -> line.split("\t"))
				.map(Sale::from)
				.collect(Collectors.toMap(
						Sale::id, 
						Sale::product));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_to_collection() {
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {
			
			var result = stream.map(line -> line.split("\t"))
				.map(Sale::from)
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
