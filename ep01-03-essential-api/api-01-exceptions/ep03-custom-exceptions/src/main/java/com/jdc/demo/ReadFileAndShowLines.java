package com.jdc.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.jdc.demo.ReadFileException.Level;

public class ReadFileAndShowLines {

	public void readAndShow(String filePath) {
		
		try {
			var path = Path.of(filePath);
			var lines = Files.readAllLines(path);
			
			for(var line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			throw new ReadFileException(
					Level.Error, 
					"Error on reading %s file.".formatted(filePath), 
					e);
		}
	}
}
