package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.id.DirectoryContents;

public class DirectoryContentsTest {

	@Test
	void test() {
		
		var service = new DirectoryContents();
		service.print("workspace", "txt");
	}
}
