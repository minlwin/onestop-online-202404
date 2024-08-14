package com.jdc.online.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistrictReaderWithStream implements DistrictReader {

	@Override
	public Map<String, List<String>> read(Path path) {
		
		try(var stream = Files.lines(path)) {
			
			return stream.map(a -> a.split("\t"))
				.collect(Collectors.groupingBy(array -> array[0], 
							Collectors.mapping(
									array -> array[1], 
									Collectors.toList())));
			
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
