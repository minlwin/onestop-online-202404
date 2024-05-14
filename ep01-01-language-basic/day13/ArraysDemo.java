class FlexibleArray {

	private String [] array = {};

	public void add(String value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
	}

	public String[] getValues() {
		return Arrays.copyOf(array, array.length);
	}
}