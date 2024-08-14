package com.jdc.online.nio2.files;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CopyBinaryFiles {

	private Path desktop;
	private Path origin;
	
	@BeforeEach
	void before_each() {
		var home = System.getProperty("user.home");
		desktop = Path.of(home).resolve("Desktop");
		
		origin = Path.of("/Users/minlwin/Downloads").resolve("MI-5.2015.720p.mp4");
	}
	
	@Test
	void test_by_copy() throws IOException {
		var destination = desktop.resolve("copy1.mp4");
		
		Files.copy(origin, destination);
		
		assertTrue(Files.exists(destination));
	}
	
	@Test
	void test_by_read_write() throws IOException {
		
		var destination = desktop.resolve("copy2.mp4");
		var bytes = Files.readAllBytes(origin);
		Files.write(destination, bytes, 
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);

		assertTrue(Files.exists(destination));
	}
}
