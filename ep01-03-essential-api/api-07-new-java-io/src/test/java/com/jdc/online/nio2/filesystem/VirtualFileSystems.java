package com.jdc.online.nio2.filesystem;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class VirtualFileSystems {
	
	@Test
	void demo_using_virutal_file_system() {
		
		var home = System.getProperty("user.home");
		
		try(var fileSystem = FileSystems.newFileSystem(Path.of(home, "Desktop", "ioc-container.zip"))) {
			
			var root = fileSystem.getRootDirectories().iterator().next();
			
			System.out.println("""
					=============================
					Direct Children of Root
					=============================
					""");
			
			try(var childern = Files.list(root)) {
				childern.forEach(path -> System.out.println(path));
			} 
			
			System.out.println("""
					=============================
					Nested Children of Root
					=============================
					""");

			try(var childern = Files.walk(root)) {
				childern.forEach(path -> System.out.println(path));
			} 
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
