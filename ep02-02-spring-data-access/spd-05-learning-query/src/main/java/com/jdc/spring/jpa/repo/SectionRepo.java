package com.jdc.spring.jpa.repo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.jdc.spring.jpa.entity.dto.SectionDto;
import com.jdc.spring.jpa.entity.dto.SectionWithStudents;

public interface SectionRepo {

	List<SectionDto> searchUnderFees(int fees);
	List<SectionDto> searchStartBetween(LocalDate from, LocalDate to);
	List<SectionDto> searchStartTimeIn(List<String> startTimes);
	List<SectionDto> searchInDays(DayOfWeek day);
	
	List<SectionWithStudents> searchOverStudents(long students);
	
}
