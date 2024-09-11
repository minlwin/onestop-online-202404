package com.jdc.online.nio2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = OrderAnnotation.class)
public class ModifyingFileAttributes {

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
	void test_check_support() throws IOException {
		
		var store = Files.getFileStore(test);
		
		System.out.printf("%s : %s%n", 
				FileAttributeView.class.getSimpleName(), 
				store.supportsFileAttributeView(FileAttributeView.class));

		System.out.printf("%s : %s%n", 
				BasicFileAttributeView.class.getSimpleName(), 
				store.supportsFileAttributeView(BasicFileAttributeView.class));

		System.out.printf("%s : %s%n", 
				FileOwnerAttributeView.class.getSimpleName(), 
				store.supportsFileAttributeView(FileOwnerAttributeView.class));

		System.out.printf("%s : %s%n", 
				DosFileAttributeView.class.getSimpleName(), 
				store.supportsFileAttributeView(DosFileAttributeView.class));

		System.out.printf("%s : %s%n", 
				PosixFileAttributeView.class.getSimpleName(), 
				store.supportsFileAttributeView(PosixFileAttributeView.class));

		System.out.printf("%s : %s%n", 
				AclFileAttributeView.class.getSimpleName(), 
				store.supportsFileAttributeView(AclFileAttributeView.class));

		System.out.printf("%s : %s%n", 
				UserDefinedFileAttributeView.class.getSimpleName(), 
				store.supportsFileAttributeView(UserDefinedFileAttributeView.class));
	}
	
	@Test
	@Order(2)
	void test_modfying_attribute() throws IOException {
		
		var attributeView = Files.getFileAttributeView(test, PosixFileAttributeView.class);
		var attributes = attributeView.readAttributes();
		
		var lastMonth = LocalDateTime.now().minusMonths(1);
		var creationTime = lastMonth.atZone(ZoneId.systemDefault())
				.toInstant();
		
		System.out.printf("Before : %s%n", attributes.creationTime());
		
		attributeView.setTimes(
				attributes.lastModifiedTime(), 
				attributes.lastAccessTime(), 
				FileTime.from(creationTime));
		
		System.out.printf("After : %s%n", 
				Files.readAttributes(test, PosixFileAttributes.class).creationTime());
	}

}
