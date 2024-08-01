package com.jdc.online.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class CopyingFile {

	@Test
	void test_copy() throws IOException {
		
		var original = Path.of(System.getProperty("user.home"), "Downloads", "20240730-02-About Legacy File.mp4");
		Files.copy(original, Path.of("newfile.mp4"));
	}
}
