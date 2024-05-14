public class MethodDemo {

	String instanceVariable = "Instance Variable";
	static String staticVariable = "Static Variable";

	public static void main(String[] args) {
		var demo = new MethodDemo();
		demo.instanceMethod2();

		staticMethod2();
	}

	void instanceMethod1() {
		System.out.println("Instance Method 1");
	}

	void instanceMethod2() {
		System.out.println("Instance Method 2");
		instanceMethod1();
		System.out.println(instanceVariable);
		staticMethod1();
		System.out.println(staticVariable);
	}

	static void staticMethod1() {
		System.out.println("Static Method 1");
	}

	static void staticMethod2() {
		System.out.println("Static Method 2");
		staticMethod1();
		System.out.println(staticVariable);
	}
}