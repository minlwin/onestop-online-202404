package com.jdc.demo.dto;

import java.util.Objects;

public class StudentDto {

	private final int id;
	private final String name;
	private final String phone;
	
	public StudentDto(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
