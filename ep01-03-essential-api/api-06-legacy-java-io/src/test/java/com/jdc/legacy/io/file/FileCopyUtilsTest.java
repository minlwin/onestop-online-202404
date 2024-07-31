package com.jdc.legacy.io.file;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.FileCopyUtils;

public class FileCopyUtilsTest {

	@Test
	void test() {
		var source = "/Users/minlwin/Desktop/15.Java Inputs - Outputs.pdf";
		assertDoesNotThrow(() -> FileCopyUtils.copy(source, "javaio.pdf"));
	}
}
