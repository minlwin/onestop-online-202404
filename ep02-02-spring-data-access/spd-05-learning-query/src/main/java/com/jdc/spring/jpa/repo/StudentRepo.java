package com.jdc.spring.jpa.repo;

import java.util.List;

import com.jdc.spring.jpa.entity.Student;

public interface StudentRepo {

	List<Student> findByPhone(String phone);
	List<Student> findByKeyword(String keyword);
	
}
