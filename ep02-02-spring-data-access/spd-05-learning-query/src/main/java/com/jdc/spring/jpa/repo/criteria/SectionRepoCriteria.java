package com.jdc.spring.jpa.repo.criteria;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.RegistrationPk_;
import com.jdc.spring.jpa.entity.Registration_;
import com.jdc.spring.jpa.entity.Section;
import com.jdc.spring.jpa.entity.SectionPk_;
import com.jdc.spring.jpa.entity.Section_;
import com.jdc.spring.jpa.entity.dto.SectionDto;
import com.jdc.spring.jpa.entity.dto.SectionWithStudents;
import com.jdc.spring.jpa.repo.SectionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.JoinType;

@Repository
@Transactional(readOnly = true)
public class SectionRepoCriteria implements SectionRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<SectionDto> searchUnderFees(int fees) {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionDto.class);
		
		var root = cq.from(Section.class);
		SectionDto.select(cq, root);
		
		cq.where(cb.le(root.get(Section_.fees), fees));
		
		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<SectionDto> searchStartBetween(LocalDate from, LocalDate to) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionDto.class);
		
		var root = cq.from(Section.class);
		SectionDto.select(cq, root);
		
		// s.id.startAt between from and to
		cq.where(cb.between(root.get(Section_.id).get(SectionPk_.startAt), from, to));

		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<SectionDto> searchStartTimeIn(List<String> startTimes) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionDto.class);
		
		var root = cq.from(Section.class);
		SectionDto.select(cq, root);
		
		// s.id.startAt between from and to
		cq.where(root.get(Section_.startTime).in(startTimes));

		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<SectionDto> searchInDays(DayOfWeek day) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionDto.class);
		
		var root = cq.from(Section.class);
		SectionDto.select(cq, root);
		
		cq.where(cb.isMember(day, root.get(Section_.days)));

		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<SectionWithStudents> searchOverStudents(long students) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SectionWithStudents.class);
		var root = cq.from(Section.class);
		
		SectionWithStudents.select(cb, cq, root);
		
		var registration = root.join(Section_.registration, JoinType.LEFT);
		
		cq.having(cb.ge(cb.count(registration.get(Registration_.id).get(RegistrationPk_.studentId)), students));
		
		cq.orderBy(cb.desc(cb.count(registration.get(Registration_.id).get(RegistrationPk_.studentId))));

		return em.createQuery(cq).getResultList();
	}

}
