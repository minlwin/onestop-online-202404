public class LocalClassDemo {

	public static void doSample() {

		class Count {
			int count = 0;
		}

		var count = new Count();

		Sample sample = () -> {
			count.count ++;
			System.out.println("Count is %d.".formatted(count.count));
		};

		sample.countUp();
	}
}

interface Sample {
	void countUp();
}