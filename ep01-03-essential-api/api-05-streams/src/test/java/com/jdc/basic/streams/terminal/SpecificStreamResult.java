package com.jdc.basic.streams.terminal;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class SpecificStreamResult {

	@Test
	void test_sum() {
		
		var sum = IntStream.rangeClosed(1, 10)
			.sum();
		
		System.out.println(sum);
	}
	
	@Test
	void test_average() {
		
		var result = IntStream.rangeClosed(1, 10)
			.average();
		
		result.ifPresent(System.out::println);
		
	}
	
	@Test
	void test_statistics() {
		
		var result = IntStream.rangeClosed(1, 10)
			.summaryStatistics();
			
		System.out.printf("Sum : %s%n", result.getSum());
		System.out.printf("Average: %s%n", result.getAverage());
		System.out.printf("Count : %s%n", result.getCount());
		System.out.printf("Max : %s%n", result.getMax());
		System.out.printf("Min : %s%n", result.getMax());
		
	}
}
