package com.jdc.console.app;

public class ConsoleApplication {

	private String appName;
	private AbstractFeature[] features;

	public ConsoleApplication(String appName, AbstractFeature[] features) {
		super();
		this.appName = appName;
		this.features = features;
	}

	public void launch() {
		// Show Welcome Message
		showMessage("Welcome to %s".formatted(appName));
		
		do {
			// Show All Menu
			// Get User Selected Menu
			var feature = getUserSelectedFeature();
			
			// Execute Selected Feature
			feature.showMenu();
			System.out.println();
			
			feature.doBusiness();
			
		} while (askTodoAgain());
		
		showMessage("See you again!");
	}

	private AbstractFeature getUserSelectedFeature() {
		System.out.println("Please select menu.");
		
		for(var feature: features) {
			feature.showMenu();
		}
		
		System.out.println();
		var selectedId = UserInputs.readInt("Feature ID : ");
				
		return features[selectedId - 1];
	}

	private void showMessage(String message) {
		System.out.println("===================================");
		System.out.println(message);
		System.out.println("===================================");
		System.out.println();
	}

	private boolean askTodoAgain() {
		System.out.println();
		var result = UserInputs.readString("Do you want to do again? (Y/Others) : ");
		System.out.println();
		return "Y".equalsIgnoreCase(result);
	}
}
