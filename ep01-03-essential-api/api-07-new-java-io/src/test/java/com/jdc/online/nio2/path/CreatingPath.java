package com.jdc.online.nio2.path;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class CreatingPath {

	@Test
	void create_via_file_system() {
		
		var fileSystem = FileSystems.getDefault();
		var home = System.getProperty("user.home");
		
		var homePath = fileSystem.getPath(home);
		
		System.out.printf("File System -> %s%n", Files.exists(homePath));
	}
	
	@Test
	void create_via_factory_class() {
		var home = System.getProperty("user.home");
		var homePath = Paths.get(home);
		System.out.printf("Factory Class -> %s%n", Files.exists(homePath));
	}
	
	@Test
	void create_via_factory_method() {
		var home = System.getProperty("user.home");
		var homePath = Path.of(home);
		System.out.printf("Factory Method -> %s%n", Files.exists(homePath));
	}
	
	@Test
	void create_with_segments() {
		var path = Path.of("parent", "child", "value.txt");
		System.out.printf("With Segments -> %s%n", Files.exists(path));
	}
}
