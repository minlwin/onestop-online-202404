package com.jdc.legacy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyUtils {

	public static void copy(String source, String distination) {
		
		try(var input = new FileInputStream(source);
				var output = new FileOutputStream(distination)) {
			input.transferTo(output);			
		} catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
