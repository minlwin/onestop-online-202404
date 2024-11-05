package com.jdc.spring.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Student.findByPhone", query = "select s from Student s where s.phone = ?1")
@NamedQuery(name = "Student.findByKeyword", 
	query = """
			select s from Student s 
				where lower(s.name) like :keyword 
				or lower(s.phone) like :keyword 
				or lower(s.email) like :keyword
			""")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private String email;

}