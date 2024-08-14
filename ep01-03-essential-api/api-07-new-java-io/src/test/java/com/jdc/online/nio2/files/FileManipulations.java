package com.jdc.online.nio2.files;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class FileManipulations {

	@Test
	void demo() throws IOException {
		
		var parent = Path.of("parent");
		var child = parent.resolve("child");
		var file = child.resolve("file.txt");
		
		assertFalse(Files.exists(parent));
		assertFalse(Files.exists(child));
		assertFalse(Files.exists(file));
		
		// Create File And Directory
		Files.createDirectories(child);
		Files.createFile(file);

		assertTrue(Files.exists(parent));
		assertTrue(Files.exists(child));
		assertTrue(Files.exists(file));
		
		var newFile = parent.resolve("newfile.txt");
		Files.move(file, newFile);
		
		Files.copy(newFile, file);
		
		Files.delete(file);
		Files.delete(newFile);
		Files.delete(child);
		Files.delete(parent);
	}
}
