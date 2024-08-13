package com.jdc.online.nio2.path;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class PathInformations {

	@Test
	void test() {
		
		var home = Path.of(System.getProperty("user.home"));
		var virtual = Path.of("parent", "child", "value.txt");
		
		showInfo(home);
		
		showInfo(virtual);
	}

	private void showInfo(Path path) {
		System.out.println("""
				=====================================
				%s
				=====================================
				""".formatted(path));
		
		System.out.printf("%s -> %s%n", "getFileName", path.getFileName());
		System.out.printf("%s -> %s%n", "getFileSystem", path.getFileSystem());
		System.out.printf("%s -> %s%n", "getParent", path.getParent());
		System.out.printf("%s -> %s%n", "getRoot", path.getRoot());
		System.out.printf("%s -> %s%n", "getNameCount", path.getNameCount());
		
		
		System.out.println("Segment of Paths");
		var iterator = path.iterator();
		while(iterator.hasNext()) {
			var segment = iterator.next();
			System.out.println(segment);
		}
	}
}
