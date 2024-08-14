package com.jdc.online.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DistrictReaderWithLopping implements DistrictReader{

	@Override
	public Map<String, List<String>> read(Path path) {
		
		var result = new LinkedHashMap<String, List<String>>();
		
		try {
			var lines = Files.readAllLines(path);
			
			for(var line : lines) {
				var array = line.split("\t");
				
				var districts = result.get(array[0]);
				
				if(null == districts) {
					districts = new ArrayList<String>();
					result.put(array[0], districts);
				}
				
				districts.add(array[1]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
