package com.jdc.legacy.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineWriteAndRead {

	private String path;
	private Scanner scanner;

	public LineWriteAndRead(String path) {
		super();
		this.path = path;
		scanner = new Scanner(System.in);
	}

	public void start() {

		try (var writer = new PrintWriter(path)) {
			while (true) {
				System.out.print("Enter > ");
				var line = scanner.nextLine();

				if (line.equalsIgnoreCase("q")) {
					break;
				}

				writer.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (var reader = new BufferedReader(new FileReader(path))) {
			
			String line = null;
			
			while(null != (line = reader.readLine())) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
