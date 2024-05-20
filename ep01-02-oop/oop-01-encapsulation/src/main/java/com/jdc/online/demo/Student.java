package com.jdc.online.demo;

import java.util.Objects;

public class Student {

	private final int id;
	private final String name;
	private final String phone;
	private final String email;
	
	public Student(int id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Student(String name, String phone, String email) {
		super();
		this.id = 0;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public Student withId(int id) {
		return new Student(id, this.name, this.phone, this.email);
	}
	
	public Student withName(String name) {
		return new Student(id, name, phone, email);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}

}
