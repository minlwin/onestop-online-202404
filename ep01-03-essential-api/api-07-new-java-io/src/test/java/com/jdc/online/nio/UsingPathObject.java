package com.jdc.online.nio;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class UsingPathObject {

	@Test
	void test_normalize() {
		var current = Path.of("./src/test/../test/../test/java");
		
		System.out.println(current);
		
		var result = Files.exists(current);
		
		System.out.println("%s is exist : %s".formatted(current, result));
		
		var normalized = current.normalize();
		
		System.out.println(normalized);
	}
	
	@Test
	void test_relativize() {
		var current = Path.of("./src/test/../test/../test/java");
		
		var normalize = current.normalize();
		System.out.println(normalize);
		
		var nio = normalize.resolve(Path.of("com/jdc/online/nio"));
		System.out.println(nio);
		
		var relativeNio = normalize.relativize(nio);
		System.out.println(relativeNio);
		
		System.out.println(relativeNio.toAbsolutePath());
	}
}
