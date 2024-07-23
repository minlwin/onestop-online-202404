package com.jdc.basic.streams.creation;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class CreateFromRange {

	@Test
	void test_range() {
		
		System.out.println("Range");
		
		var stream = IntStream.range(1, 5);
		
		var result = stream.mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
		
		System.out.println(result);
	}
	
	@Test
	void test_range_closed() {
		
		System.out.println("Range Closed");

		var stream = IntStream.rangeClosed(1, 5);
		
		var result = stream.mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
		
		System.out.println(result);
	}
}
