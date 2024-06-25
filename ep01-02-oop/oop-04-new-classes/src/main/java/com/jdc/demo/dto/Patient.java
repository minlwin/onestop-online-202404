package com.jdc.demo.dto;

import java.time.LocalDate;

public record Patient(int id, String name, String phone, String email, Gender gender, LocalDate dob, String bloodType,
		String address) {

	public static class Builder {
		private int id;
		private String name;
		private String phone;
		private String email;
		private Gender gender;
		private LocalDate dob;
		private String bloodType;
		private String address;

		public Builder id(int id) {
			this.id = id;
			return this;
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

		public Builder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public Builder dob(LocalDate dob) {
			this.dob = dob;
			return this;
		}

		public Builder bloodType(String bloodType) {
			this.bloodType = bloodType;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Patient build() {
			return new Patient(id, name, phone, email, gender, dob, bloodType, address);
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	public enum Gender {
		Male, Female
	}
}
