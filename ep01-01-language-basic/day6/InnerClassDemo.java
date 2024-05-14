public class InnerClassDemo {

	private String name;

	public InnerClassDemo(String name) {
		this.name = name;
	}

	public class Inner {

		public Inner() {

		}

		public String getName() {
			return name;
		}
	}
}