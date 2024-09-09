package com.jdc.spring.pos.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.jdc.spring.pos.domain.output.SaleInfo;

public interface SaleHistoryRepo {

	int create(String salePerson);

	List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to);

	Optional<SaleInfo> findById(int id);

}
