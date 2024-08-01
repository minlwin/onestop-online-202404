package com.jdc.online.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class FileSystemDemo {

	@Test
	void test_default_fs() {
		
		var fs = FileSystems.getDefault();
		var userHome = System.getProperty("user.home");
		
		System.out.println(userHome);
		
		var homePath = fs.getPath(userHome);
		
		try(var paths = Files.list(homePath)) {
			var list = paths.collect(Collectors.mapping(path -> path.toString(), Collectors.toList()));
			System.out.println(list);
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	@Test
	void test_virtual_fs() throws IOException {
		
		var userHome = System.getProperty("user.home");
		var zipFile = Path.of(userHome, "Desktop", "certificate.zip");
		
		var zipFs = FileSystems.newFileSystem(zipFile);
		
		var certificate = zipFs.getPath("/certificate");
		
		try(var stream = Files.list(certificate)) {
			stream.forEach(file -> System.out.println(file));
		}
	}
}
