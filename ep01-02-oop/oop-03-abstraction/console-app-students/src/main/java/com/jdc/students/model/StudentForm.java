package com.jdc.students.model;

public class StudentForm {

	private String name;
	private String phone;
	private String email;
	private String address;

	public StudentForm() {
	}

	public StudentForm(String name, String phone, String email, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentForm [name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}

}