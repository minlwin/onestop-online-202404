package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.id.TextFileReader;

public class TextFileReaderTest {

	@Test
	void test() {
		
		var service = new TextFileReader();
		var list = service.read("workspace/data.txt");
		System.out.println(list);
	}
}
