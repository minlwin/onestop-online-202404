package com.jdc.spring.pos.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdc.spring.pos.domain.output.SaleInfo;

@Repository
public class SaleHistoryRepoImpl implements SaleHistoryRepo{

	@Override
	public int create(String salePerson) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleInfo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
