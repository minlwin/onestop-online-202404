package com.jdc.legacy.io.file;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class UsingFile {

	@Test
	void test_create_file_object() throws IOException {
		
		System.out.println("""
				-----------------------
				Create File Object
				-----------------------
				""");
		
		var data = new File("data");
		data.deleteOnExit();
		
		// ./data/sub
		var subData = new File(data, "sub");
		subData.deleteOnExit();
		
		System.out.printf("Data is exists : %s%n", data.exists());
		System.out.printf("Data is directory : %s%n", data.isDirectory());
		System.out.printf("Data is file : %s%n", data.isFile());
		
		System.out.printf("Sub Data is exists : %s%n", subData.exists());
		System.out.printf("Sub Data is directory : %s%n", subData.isDirectory());
		System.out.printf("Sub Data is file : %s%n", subData.isFile());
		
		// ./data/sub/test.txt
		var file = new File("data/sub", "test.txt");
		file.deleteOnExit();
		
		System.out.printf("Test File is exists : %s%n", file.exists());
		System.out.printf("Test File is directory : %s%n", file.isDirectory());
		System.out.printf("Test File is file : %s%n", file.isFile());
		
		if(file.getParentFile() != null && !file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			System.out.printf("Data is exists : %s%n", data.exists());
			System.out.printf("Data is directory : %s%n", data.isDirectory());
			System.out.printf("Data is file : %s%n", data.isFile());
			
			System.out.printf("Sub Data is exists : %s%n", subData.exists());
			System.out.printf("Sub Data is directory : %s%n", subData.isDirectory());
			System.out.printf("Sub Data is file : %s%n", subData.isFile());
		}
		
		System.out.printf("Test File is created : %s%n", file.createNewFile());
		
	}
}
