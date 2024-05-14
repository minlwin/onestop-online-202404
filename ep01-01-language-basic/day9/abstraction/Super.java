public class Super {

	public String name;

	public static int count;

	public Super(String name) {
		this.name = name;
		count ++;
	}

	public void greet() {
		System.out.println("Hello! I am %s.".formatted(name));
	}

	public static void showCount() {
		System.out.println("Count is %d.".formatted(count));
	}

}