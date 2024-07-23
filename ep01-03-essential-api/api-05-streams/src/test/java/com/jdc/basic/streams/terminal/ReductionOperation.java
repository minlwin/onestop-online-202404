package com.jdc.basic.streams.terminal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class ReductionOperation {

	@Test
	void test_reduce_with_identifier() {
		
		var stream = Stream.of(1, 2, 3, 4, 5);
		
		var sum = stream.reduce(0, (a, b) -> a + b);
		
		assertEquals(15, sum);
		
		stream = Stream.of();
		
		sum = stream.reduce(0, (a, b) -> a + b);
		
		assertEquals(0, sum);
	}
	
	@Test
	void test_reduce_without_identifier() {
		
		var stream = Stream.of(1, 2, 3, 4, 5);
		
		var sum = stream.reduce((a, b) -> a + b);
		
		assertEquals(15, sum.get());
		
		stream = Stream.of();
		
		sum = stream.reduce((a, b) -> a + b);
		
		assertFalse(sum.isPresent());
		
	}
	
	@Test
	void test_reduce_to_other_types() {
		var stream = Stream.of(1, 2, 3, 4, 5);
		
		var result = stream.reduce(
				new ArrayList<Integer>(), 
				(list, element) -> {
					list.add(element);
					return list;
				}, 
				(a, b) -> {
					a.addAll(b);
					return a;
				});
		
		System.out.println(result);
	}
}
