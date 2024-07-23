package com.jdc.basic.streams.creation;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class CreateFromFile {

	@Test
	void test_from_file() {
		
		try(var stream = Files.lines(Path.of("data", "poem.txt"))) {
			
			stream.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
