package com.jdc.spring.jpa.entity.dto;

import java.time.LocalDate;

import com.jdc.spring.jpa.entity.Course_;
import com.jdc.spring.jpa.entity.RegistrationPk_;
import com.jdc.spring.jpa.entity.Registration_;
import com.jdc.spring.jpa.entity.Section;
import com.jdc.spring.jpa.entity.SectionPk;
import com.jdc.spring.jpa.entity.Section_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public record SectionWithStudents(
		SectionPk id,
		LocalDate endAt,
		String courseName,
		long students
		) {

	public static void select(CriteriaBuilder cb, CriteriaQuery<SectionWithStudents> cq, Root<Section> root) {
		
		var registration = root.join(Section_.registration, JoinType.LEFT);
		var course = root.join(Section_.course, JoinType.LEFT);
		
		cq.multiselect(
			root.get(Section_.id),
			root.get(Section_.endAt),
			course.get(Course_.name),
			cb.count(registration.get(Registration_.id).get(RegistrationPk_.studentId))
		);
		
		cq.groupBy(
			root.get(Section_.id),
			root.get(Section_.endAt),
			course.get(Course_.name)
		);
	}
}
