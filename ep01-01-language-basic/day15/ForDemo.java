import java.util.Scanner;

public class ForDemo {

	public static void main(String[] args) {
		new ForDemo().launch();
	}

	private Scanner scanner = new Scanner(System.in);

	public void launch() {

		// Show Welcome Message
		showMessage("Welcome to calculator!");

		// Start Loop
		for(boolean again = true; again; again = askUserToDoAgain()) {
			// Get Input 1
			int input1 = getUserInput("Enter Digit 1 : ");
			// Get Input 2
			int input2 = getUserInput("Enter Digit 2 : ");

			// Show add result
			int result = input1 + input2;

			if(result < 0) {
				continue;
			}

			System.out.printf("%d + %d = %d%n%n", input1, input2, result);
		}

		showMessage("Thank you! See you again.");
	}

	private boolean askUserToDoAgain() {
		System.out.print("Do you want to do again? (y, Others) : ");
		var input = scanner.nextLine();
		System.out.println();
		return "y".equalsIgnoreCase(input);
	}

	private int getUserInput(String message) {
		System.out.print(message);
		var input = scanner.nextLine();
		return Integer.parseInt(input);
	}

	private void showMessage(String message) {
		System.out.println("=========================");
		System.out.println(message);
		System.out.println("=========================");
		System.out.println();
	}
}