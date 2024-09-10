package com.jdc.online.nio2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.time.Instant;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileAttributeFlutentMethods {
	
	static Path test;

	static {
		var desktop = Path.of(System.getProperty("user.home"), "Desktop");
		test = desktop.resolve("demo.txt");
	}
	
	@BeforeAll
	static void init() throws IOException {
		
		if(Files.exists(test)) {
			Files.delete(test);
		}
		
		Files.createFile(test);
	}
	
	@Test
	void test() throws IOException {
		
		show("Before Updating");
		
		Files.setLastModifiedTime(test, FileTime.from(Instant.now().plusSeconds(60)));
		
		var posix = new HashSet<>(Files.getPosixFilePermissions(test));
		posix.add(PosixFilePermission.GROUP_WRITE);
		
		Files.setPosixFilePermissions(test, posix);
		
		show("After Updating");
	}
	
	
	private void show(String title) throws IOException {
		
		System.out.println(title);
		
		var lastModified = Files.getLastModifiedTime(test);
		var owner = Files.getOwner(test);
		var permissions = Files.getPosixFilePermissions(test);
		
		System.out.printf("Last Modified : %s%n", lastModified);
		System.out.printf("Owner : %s%n", owner);
		System.out.printf("Permissions : %s%n", permissions);
	}
	
	
}
