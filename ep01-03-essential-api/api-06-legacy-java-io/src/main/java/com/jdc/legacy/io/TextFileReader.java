package com.jdc.legacy.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
	
	public List<String> read(String path) {
		
		var list = new ArrayList<String>();
		
		try(var reader = new BufferedReader(new FileReader(path))) {
			
			String line = null;
			
			while(null != (line = reader.readLine())) {
				list.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}
