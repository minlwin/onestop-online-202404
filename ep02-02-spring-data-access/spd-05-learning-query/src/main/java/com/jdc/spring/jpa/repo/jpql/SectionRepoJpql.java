package com.jdc.spring.jpa.repo.jpql;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.dto.SectionDto;
import com.jdc.spring.jpa.entity.dto.SectionWithStudents;
import com.jdc.spring.jpa.repo.SectionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class SectionRepoJpql implements SectionRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<SectionDto> searchUnderFees(int fees) {
		var query = em.createNamedQuery("Section.searchUnderFees", SectionDto.class);
		query.setParameter("fees", fees);
		return query.getResultList();
	}

	@Override
	public List<SectionDto> searchStartBetween(LocalDate from, LocalDate to) {
		var query = em.createNamedQuery("Section.searchStartBetween", SectionDto.class);
		query.setParameter("from", from);
		query.setParameter("to", to);
		return query.getResultList();
	}

	@Override
	public List<SectionDto> searchStartTimeIn(List<String> startTimes) {
		var query = em.createNamedQuery("Section.searchStartTimeIn", SectionDto.class);
		query.setParameter("list", startTimes);
		return query.getResultList();
	}

	@Override
	public List<SectionDto> searchInDays(DayOfWeek day) {
		var query = em.createNamedQuery("Section.searchInDays", SectionDto.class);
		query.setParameter("day", day);
		return query.getResultList();
	}

	@Override
	public List<SectionWithStudents> searchOverStudents(long students) {
		var query = em.createNamedQuery("Section.searchOverStudents", SectionWithStudents.class);
		query.setParameter("students", students);
		return query.getResultList();
	}

}
