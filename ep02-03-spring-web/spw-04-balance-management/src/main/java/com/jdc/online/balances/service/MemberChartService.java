package com.jdc.online.balances.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.controller.member.dto.ChartAmountVo;
import com.jdc.online.balances.controller.member.dto.ChartBalanceVo;
import com.jdc.online.balances.controller.member.dto.ChartSummaryVo;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.model.repo.LedgerEntryRepo;
import com.jdc.online.balances.utils.LoadType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberChartService {
	
	private final LedgerEntryRepo entryRepo;
	
	public ChartSummaryVo getSummaryData(LoadType type) {
		return switch(type) {
		case Monthly -> getSummaryDataForMonth();
		case Yearly -> getSummaryDataForYear();
		};
	}

	private ChartSummaryVo getSummaryDataForYear() {
		var to = LocalDate.now();
		var from = to.minusYears(1);
		
		var incomes = getSummaryData(BalanceType.Incomes, from, to);
		var expenses = getSummaryData(BalanceType.Expenses, from, to);
		
		return new ChartSummaryVo(getValue(incomes), getValue(expenses));
	}

	private ChartSummaryVo getSummaryDataForMonth() {
		var to = LocalDate.now();
		var from = to.minusMonths(1);
		
		var incomes = getSummaryData(BalanceType.Incomes, from, to);
		var expenses = getSummaryData(BalanceType.Expenses, from, to);
		
		return new ChartSummaryVo(getValue(incomes), getValue(expenses));
	}
	
	public List<ChartBalanceVo> getBalanceData(LoadType type) {
		return switch(type) {
		case Monthly -> getBalanceDataForMonth();
		case Yearly -> getBalanceDataForYear();
		};
	}

	private List<ChartBalanceVo> getBalanceDataForMonth() {
		
		var result = new ArrayList<ChartBalanceVo>();
		var fromDate = LocalDate.now().minusMonths(1);
		
		while(fromDate.compareTo(LocalDate.now()) <= 0) {
			var toDate = fromDate.plusWeeks(1);
			
			if(fromDate.compareTo(toDate) < 0) {
				var incomes = getSummaryData(BalanceType.Incomes, fromDate, toDate);
				var expenses = getSummaryData(BalanceType.Expenses, fromDate, toDate);
				result.add(new ChartBalanceVo(fromDate, getValue(expenses), getValue(incomes)));
			}
			
			fromDate = toDate.plusDays(1);
		}
		
		return result;
	}

	private List<ChartBalanceVo> getBalanceDataForYear() {
		
		var result = new ArrayList<ChartBalanceVo>();
		var fromDate = LocalDate.now().minusYears(1);
		
		while(fromDate.compareTo(LocalDate.now()) <= 0) {
			var toDate = fromDate.plusMonths(3);
			
			if(fromDate.compareTo(toDate) < 0) {
				var incomes = getSummaryData(BalanceType.Incomes, fromDate, toDate);
				var expenses = getSummaryData(BalanceType.Expenses, fromDate, toDate);
				result.add(new ChartBalanceVo(fromDate, getValue(expenses), getValue(incomes)));
			}
			
			fromDate = toDate.plusDays(1);
		}
		
		return result;
	}

	public Map<BalanceType, List<ChartAmountVo>> getLedgerData(LoadType type) {
		return switch(type) {
		case Monthly -> getLedgerDataForMonth();
		case Yearly -> getLedgerDataForYear();
		};
	}

	private Map<BalanceType, List<ChartAmountVo>> getLedgerDataForYear() {
		var toDate = LocalDate.now();
		var fromDate = toDate.minusYears(1);
		
		var result = new HashMap<BalanceType, List<ChartAmountVo>>();
		result.put(BalanceType.Incomes, getLedgerData(BalanceType.Incomes, fromDate, toDate));
		result.put(BalanceType.Expenses, getLedgerData(BalanceType.Expenses, fromDate, toDate));
		
		return result;
	}

	private Map<BalanceType, List<ChartAmountVo>> getLedgerDataForMonth() {
		var toDate = LocalDate.now();
		var fromDate = toDate.minusMonths(1);
		
		var result = new HashMap<BalanceType, List<ChartAmountVo>>();
		result.put(BalanceType.Incomes, getLedgerData(BalanceType.Incomes, fromDate, toDate));
		result.put(BalanceType.Expenses, getLedgerData(BalanceType.Expenses, fromDate, toDate));
		
		return result;
	}
	
	private List<ChartAmountVo> getLedgerData(BalanceType type, LocalDate from, LocalDate to) {
		var username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		var list = entryRepo.getLedgerData(username, type, from, to);
		return list.stream().filter(a -> a.value().compareTo(BigDecimal.ZERO) > 0)
				.toList();
	}

	private BigDecimal getSummaryData(BalanceType type, LocalDate from, LocalDate to) {
		var username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		return entryRepo.getSummaryData(username, type, from, to);
	}

	public BigDecimal getValue(BigDecimal value) {
		return Optional.ofNullable(value).orElse(BigDecimal.ZERO);
	}
	
}
