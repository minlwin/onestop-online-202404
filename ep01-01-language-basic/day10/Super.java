public class Super {

	public String name;
	public static int count;

	public final String type;

	public static final String message;

	static {
		message = "Hello from super class";
	}

	public Super(String name) {
		this.name = name;
		type = "Super Type";
		count ++;
	}

	protected void greet() {
		System.out.println("Hello! I am %s.".formatted(name));
	}

	public static strictfp final void showCount() {

		final String others;
		others = "Hello";

		System.out.println(others);

		System.out.println("Count is %d.".formatted(count));
	}

}