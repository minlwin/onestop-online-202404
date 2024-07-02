package com.jdc.console.app;

import com.jdc.console.app.exceptions.ConsoleAppException;

public class ConsoleApplication {

	private String appName;
	private AbstractFeature[] features;

	public ConsoleApplication(String appName, AbstractFeature ... features) {
		super();
		this.appName = appName;
		this.features = features;
	}

	public void launch() {
		// Show Welcome Message
		showMessage("Welcome to %s".formatted(appName));
		
		boolean skipAsking = false;
		
		do {
			
			try {
				
				skipAsking = false;
				
				// Show All Menu
				// Get User Selected Menu
				var feature = getUserSelectedFeature();
				
				// Execute Selected Feature
				feature.showMenu();
				System.out.println();
				
				feature.doBusiness();
			} catch (ConsoleAppException e) {
				System.out.printf("Error : %s%n%n", e.getMessage());
				skipAsking = true;
			}
			
		} while (skipAsking || askTodoAgain());
		
		showMessage("See you again!");
	}

	private AbstractFeature getUserSelectedFeature() {
		
		try {
			System.out.println("Please select menu.");
			
			for(var feature: features) {
				feature.showMenu();
			}
			
			System.out.println();
			var selectedId = UserInputs.readInt("Feature ID");
			
			return features[selectedId - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ConsoleAppException("Please enter valid feature id.", e);
		}
	}

	private void showMessage(String message) {
		System.out.println("===================================");
		System.out.println(message);
		System.out.println("===================================");
		System.out.println();
	}

	private boolean askTodoAgain() {
		System.out.println();
		var result = UserInputs.readString("Do you want to do again? (Y/Others)");
		System.out.println();
		return "Y".equalsIgnoreCase(result);
	}
}
