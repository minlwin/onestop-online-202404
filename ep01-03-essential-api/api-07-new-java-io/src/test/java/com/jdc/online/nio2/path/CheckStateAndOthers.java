package com.jdc.online.nio2.path;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class CheckStateAndOthers {

	@Test
	void checkState() {
		
		var src = Path.of("src");
		System.out.println("""
				========================
				%s
				========================
				""".formatted(src));
		
		System.out.printf("%s -> %s%n", "isAbsolute", src.isAbsolute());
		System.out.printf("%s -> %s%n", "startsWith", src.startsWith("src"));
		System.out.printf("%s -> %s%n", "endsWith", src.endsWith("src"));
	}
	
	@Test
	void toOtherType() {
		var src = Path.of("src").toAbsolutePath();
		
		System.out.println(src.toFile());
		System.out.println(src.toUri());
	}
}
