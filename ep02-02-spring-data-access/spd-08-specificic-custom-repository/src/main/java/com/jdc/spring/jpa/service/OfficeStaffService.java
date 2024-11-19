package com.jdc.spring.jpa.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.OfficeStaff;
import com.jdc.spring.jpa.entity.OfficeStaff.Position;
import com.jdc.spring.jpa.entity.OfficeStaff_;
import com.jdc.spring.jpa.repo.OfficeStaffRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;

@Service
public class OfficeStaffService {
	
	@Autowired
	private OfficeStaffRepo staffRepo;

	@Transactional(readOnly = true)
	public Long searchCount(Position position, LocalDate entryFrom) {
		return staffRepo.count(countFunc(position, entryFrom));
	}

	private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(Position position, LocalDate entryFrom) {
		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(OfficeStaff.class);
			
			cq.select(cb.count(root.get(OfficeStaff_.id)));
			
			var list = new ArrayList<Predicate>();
			
			if(position != null) {
				list.add(cb.equal(root.get(OfficeStaff_.position), position));
			}
			
			if(entryFrom != null) {
				list.add(cb.greaterThanOrEqualTo(root.get(OfficeStaff_.entryAt), entryFrom));
			}
			
			cq.where(list.toArray(size -> new Predicate[size]));
			
			return cq;
		};
	}
}
