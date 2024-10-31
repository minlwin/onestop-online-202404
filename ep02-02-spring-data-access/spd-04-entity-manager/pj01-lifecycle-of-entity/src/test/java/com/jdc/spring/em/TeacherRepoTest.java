package com.jdc.spring.em;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.em.entity.Contact;
import com.jdc.spring.em.entity.Teacher;
import com.jdc.spring.em.repo.TeacherRepo;

@SpringBootTest
public class TeacherRepoTest {
	
	@Autowired
	private TeacherRepo repo;

	@Test
	public void test() {
		
		var teacher = new Teacher();
		teacher.setName("Teacher");
		
		var contact = new Contact();
		contact.setPhone("09181817176");
		contact.setEmail("teacher@gmail.com");
		contact.setTeacher(teacher);
		
		teacher.setContact(contact);
		
		repo.create(teacher);
	}
}
