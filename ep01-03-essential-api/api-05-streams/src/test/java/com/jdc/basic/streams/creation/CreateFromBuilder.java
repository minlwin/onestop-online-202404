package com.jdc.basic.streams.creation;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateFromBuilder {

	@Test
	void test_builder() {
		
		var stream = Stream.builder()
				.add("Java")
				.add("Lambda Expression")
				.add("Stream API")
				.build();
		
		stream.forEach(System.out::println);
	}
}
