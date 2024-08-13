package com.jdc.online.nio2.path;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class GetOtherPath {

	@Test
	void demo() {
		var existPath = Path.of("src");
		var virtualPath = Path.of("virtual");
		
		toAbsolutePath(existPath);
		toAbsolutePath(virtualPath);
		
		System.out.println("""
				===========================
				Relativize
				===========================
				""");
		
		var relativePath = existPath.relativize(virtualPath);
		System.out.println(relativePath);
		System.out.println(existPath);
		System.out.println(virtualPath);
		System.out.println();
		
		System.out.println("""
				===========================
				Normalize
				===========================
				""");
		
		var original = Path.of("../src/../src");
		System.out.println(original);
		System.out.println(original.normalize());
		System.out.println();
		
		System.out.println("""
				===========================
				Resolve
				===========================
				""");
		
		var childOfVirtual = virtualPath.resolve("child");
		System.out.println(childOfVirtual);
		System.out.println();

		System.out.println("""
				===========================
				Resolve Sibling
				===========================
				""");
		
		var sibling = virtualPath.resolveSibling("child");
		System.out.println(sibling);
		System.out.println();
		
		System.out.println("""
				===========================
				Sub Path
				===========================
				""");
		
		var absolute = sibling.toAbsolutePath();
		var subPath = absolute.subpath(1, 3);
		System.out.println(absolute);
		System.out.println(subPath);
		
	}

	private void toAbsolutePath(Path path) {
		System.out.println("""
				===========================
				To Absolute Path
				===========================
				""");
		System.out.println(path);
		System.out.println(path.toAbsolutePath());
		System.out.println(path);
		
		System.out.println();
	}
	
	
}
