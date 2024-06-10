package com.jdc.console.app;

import java.util.Scanner;

public class UserInputs {

	private static final Scanner scanner = new Scanner(System.in);

	public static int readInt(String string) {
		var result = readString(string);
		return Integer.parseInt(result);
	}

	public static String readString(String string) {
		System.out.print(string);
		return scanner.nextLine();
	}

	public static int readInt(int size, String string) {
		var result = readString(size, string);
		return Integer.parseInt(result);
	}

	public static String readString(int size, String string) {
		var message = "%%-%ds: ".formatted(size).formatted(string);
		return readString(message);
	}
}
