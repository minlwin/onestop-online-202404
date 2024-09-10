package com.jdc.online.nio2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = OrderAnnotation.class)
public class ReadingFileAttributes {

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
	@Order(1)
	void test_using_interface() throws IOException {
		
		System.out.println("""
				Using Attributes Interfaces
				----------------------------------
				""");
		
		var attributes = Files.readAttributes(test, PosixFileAttributes.class);
		
		System.out.printf("creationTime : %s%n", attributes.creationTime());
		System.out.printf("fileKey : %s%n", attributes.fileKey());
		System.out.printf("isDirectory : %s%n", attributes.isDirectory());
		System.out.printf("isOther : %s%n", attributes.isOther());
		System.out.printf("isRegularFile : %s%n", attributes.isRegularFile());
		System.out.printf("isSymbolicLink : %s%n", attributes.isSymbolicLink());
		System.out.printf("lastAccessTime : %s%n", attributes.lastAccessTime());
		System.out.printf("lastModifiedTime : %s%n", attributes.lastModifiedTime());
		System.out.printf("size : %s%n", attributes.size());

		System.out.printf("group : %s%n", attributes.group());
		System.out.printf("owner : %s%n", attributes.owner());
		System.out.printf("permissions : %s%n", attributes.permissions());

	}
	
	@Test
	@Order(2)
	void test_using_names() throws IOException {
		
		System.out.println("""
				
				Using Attributes Names
				----------------------------------
				""");
		
		var attributes = Files.readAttributes(test, "posix:*");
		
		for(var key : attributes.keySet()) {
			System.out.printf("%s : %s%", key, attributes.get(key));
		}
	}	
}
