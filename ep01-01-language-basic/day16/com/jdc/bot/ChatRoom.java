package com.jdc.bot;

import java.util.Scanner;

public class ChatRoom {

	private Scanner scanner;
	private CrazyBot bot;

	public ChatRoom() {
		scanner = new Scanner(System.in);
		bot = new CrazyBot();
	}

	public static void main(String[] args) {
		new ChatRoom().launch();
	}

	public void launch() {
		showMessage("""
			Welcome to Bot Program
			Teach Bot and Talk to Bot!""");

		while(true) {
			var message = getUserInput();

			if("Exit".equalsIgnoreCase(message)) {
				System.out.println();
				break;
			}

			var response = bot.talk(message);
			System.out.printf("Bot > %s%n%n", response);
		}

		showMessage("Thank you! See you again.");
	}

	private String getUserInput() {
		System.out.print("You > ");
		return scanner.nextLine();
	}

	private void showMessage(String mesage) {
		System.out.println("==========================");
		System.out.println(mesage);
		System.out.println("==========================");
		System.out.println();
	}
}