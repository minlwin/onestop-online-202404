package com.jdc.online.nio2.filesystem;

import java.io.IOException;
import java.nio.file.FileSystems;

import org.junit.jupiter.api.Test;

public class UsingFileSystems {
	
	@Test
	void demo_for_default_file_system() {
		
		try {
			
			var fileSystem = FileSystems.getDefault();
			
			System.out.println("""
					===========================================
					File Stores for default file system
					===========================================
					""");
			
			for(var store : fileSystem.getFileStores()) {
				System.out.printf("Store Name : %s%n", store.name());
				System.out.printf("Store Type : %s%n", store.type());
				System.out.printf("Total Space : %s%n", store.getTotalSpace());
				System.out.printf("Unallocated Space : %s%n", store.getUnallocatedSpace());
				System.out.printf("Usable Space : %s%n", store.getUsableSpace());
			}
			
			System.out.println("""
					===========================================
					Root Directories for default file system
					===========================================
					""");
			
			for(var root : fileSystem.getRootDirectories()) {
				System.out.println(root);
			}
			
			System.out.println("""
					===========================================
					Supported Attribute for default file system
					===========================================
					""");
			for(var attributeViews : fileSystem.supportedFileAttributeViews()) {
				System.out.println(attributeViews);
			}

		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
