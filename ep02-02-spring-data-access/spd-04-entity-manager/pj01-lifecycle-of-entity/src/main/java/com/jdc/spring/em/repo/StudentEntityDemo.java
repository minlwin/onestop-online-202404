package com.jdc.spring.em.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.jdc.spring.em.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StudentEntityDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public void demo() {
		
		// New or Transient State
		var entity = new Student();
		entity.setName("Demo Student");
		entity.setPhone("0911112222");
		entity.setEmail("demo@gmail.com");
		
		var trx1 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		// Managed State
		em.persist(entity);
		
		transactionManager.commit(trx1);
				
		var trx2 = transactionManager.getTransaction(new DefaultTransactionDefinition());

		// Managed State
		var newEntity = em.find(Student.class, entity.getId());
		
		em.detach(newEntity);
		
		newEntity.setName("Min Lwin");
		
		em.merge(newEntity);
		
		transactionManager.commit(trx2);
		
		var trx3 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		newEntity = em.merge(newEntity);
		em.remove(newEntity);
		
		transactionManager.commit(trx3);
	}
}
