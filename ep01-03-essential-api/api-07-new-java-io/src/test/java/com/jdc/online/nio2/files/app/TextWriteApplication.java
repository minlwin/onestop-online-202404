package com.jdc.online.nio2.files.app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class TextWriteApplication {

	public static void main(String[] args) {
		new TextWriteApplication().launch();
	}
	
	private Scanner scanner = new Scanner(System.in);
	private Path path = Path.of("students.txt");
	
	private void launch() {
		
		System.out.println("""
				=================================
				Welcome to Text Write Application
				=================================
				""");
		
		var exist = false;
		
		do {
			
			var menu = chooseMenuId();
			
			System.out.println();
			
			switch (menu) {
			case "1" -> register();
			case "2" -> showAll();
			default -> exist = true;
			}
			
			System.out.println();
			
		} while(!exist);
		
		System.out.println("""
				
				=================================
				Thank you for using application
				=================================""");
		
	}

	private void register() {
		
		System.out.println("Student Registration");
		System.out.println();
		
		var name = read("Name");
		var phone = read("Phone");
		var email = read("Email");
		
		var student = new Student(name, phone, email);
		
		try {
			
			Files.writeString(path , student.line(), 
					StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String read(String name) {
		System.out.printf("%-8s : ", name);
		return scanner.nextLine();
	}

	private void showAll() {
		System.out.println("Show All Students");
		System.out.println();
		
		try {
			
			var lines = Files.readAllLines(path);
			for(var line : lines) {
				var student = Student.from(line);
				System.out.println(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String chooseMenuId() {
		System.out.println("""
				1      -> Student Registration
				2      -> Show All Students
				Others -> Exist""");
		
		System.out.print("Menu ID : ");
		return scanner.nextLine();
	}
}
