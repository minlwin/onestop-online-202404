package com.jdc.spring.em.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.jdc.spring.em.entity.Contact;
import com.jdc.spring.em.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class TeacherEntityDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public void demo() {
		
		var teacher = new Teacher();
		teacher.setName("Teacher");
		
		var contact = new Contact();
		contact.setPhone("09181817176");
		contact.setEmail("teacher@gmail.com");
		contact.setTeacher(teacher);
		
		teacher.setContact(contact);
		
		var trx1 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		em.persist(teacher);
		
		transactionManager.commit(trx1);
		
		var trx2 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		var entity2 = em.find(Teacher.class, teacher.getId());
		
		entity2.setContact(null);
		
		transactionManager.commit(trx2);
		
		var trx3 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		var entity3 = em.find(Teacher.class, teacher.getId());
		
		em.detach(entity3);
		
		entity3.setContact(contact);
		contact.setTeacher(entity3);
		
		em.merge(entity3);
		
		transactionManager.commit(trx3);

		var trx4 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		var entity4 = em.find(Teacher.class, teacher.getId());
		
		em.remove(entity4);
		
		transactionManager.commit(trx4);
	}
}
