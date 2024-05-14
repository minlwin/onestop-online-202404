public class Child extends Super {

	private String name;
	public static int count;

	private String type;

	public Child(String name) {
		super(name);
		this.name = name.toUpperCase();
	}

	@Override
	public void greet() {
		System.out.println("Hello from child! I am %s.".formatted(name));
		System.out.println("Name from super class is %s.".formatted(super.name));
	}

	public static void usingHiddenMethod() {
		Super.showCount();
	}
}