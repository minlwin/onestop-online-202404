package com.jdc.spring.jpa.entity.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jdc.spring.jpa.entity.Course_;
import com.jdc.spring.jpa.entity.Section;
import com.jdc.spring.jpa.entity.SectionPk;
import com.jdc.spring.jpa.entity.Section_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public record SectionDto(
		int courseId,
		LocalDate startAt,
		LocalDate endAt,
		int hours,
		String startTime,
		String endTime,
		String courseName,
		int fees,
		List<DayOfWeek> days) {
	
	public SectionDto(
			SectionPk id,
			int hours,
			LocalDate endAt,
			String startTime,
			String endTime,
			String courseName,
			int fees,
			String daysCol) {
		this(id.getCourseId(), id.getStartAt(), endAt, hours, startTime, endTime, courseName, fees, toDays(daysCol));
	}
	
	private static List<DayOfWeek> toDays(String str) {
		if(StringUtils.hasLength(str)) {
			Arrays.stream(str.split(",")).map(a -> DayOfWeek.valueOf(a)).toList();
		}
		
		return null;
	}

	public static void select(CriteriaQuery<SectionDto> cq, Root<Section> root) {
		
		var course = root.join(Section_.course, JoinType.LEFT);
		
		cq.multiselect(
			root.get(Section_.id),
			course.get(Course_.hours),
			root.get(Section_.endAt),
			root.get(Section_.startTime),
			root.get(Section_.endTime),
			course.get(Course_.name),
			root.get(Section_.fees),
			root.get(Section_.daysCol)
		);
	}
}
