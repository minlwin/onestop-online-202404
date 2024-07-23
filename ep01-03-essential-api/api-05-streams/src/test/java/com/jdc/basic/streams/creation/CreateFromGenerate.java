package com.jdc.basic.streams.creation;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class CreateFromGenerate {

	@Test
	void test_generate() {
		
		var random = ThreadLocalRandom.current();
		
		var stream = IntStream.generate(() -> random.nextInt(1, 9999));
		
		stream.mapToObj(a -> "%04d".formatted(a)).limit(10)
			.forEach(System.out::println);
		
	}
}
