package com.jdc.legacy.io;

import java.io.File;

public class DirectoryContents {

	public void print(String path, String extension) {
		
		var directory = new File(path);
		
		if(directory.isDirectory()) {
			var children = directory.listFiles((dir, name) -> {
				
				var sub = new File(dir, name);
				if(sub.isDirectory()) {
					return true;
				}
				
				return name.endsWith(extension);
			});
			
			for(var child : children) {
				print(child.getPath(), extension);
			}
			
		} else {
			System.out.println(path);
		}
		
	}
}
