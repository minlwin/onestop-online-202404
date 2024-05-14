package com.jdc.app.service;

import com.jdc.app.model.*;

public class StudentService extends StudentRepo{

	private AddressService addressService;

	public String[] getAll() {
		return getAllStudents();
	}

	public String findAddressByCode(String code) {
		return addressService.findByStudentCode(code);
	}
}