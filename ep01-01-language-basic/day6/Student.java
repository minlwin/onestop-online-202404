public class Student {

	String name;
	String phone;
	String email;
	String address;

	public static class Builder {

		String name;
		String phone;
		String email;
		String address;

		public Student build() {
			var student = new Student();
			student.name = name;
			student.phone = phone;
			student.email = email;
			student.address = address;
			return student;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}
	}

}