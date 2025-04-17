package com.jdc.online.balances.controller.member;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.online.balances.controller.member.dto.ChartAmountVo;
import com.jdc.online.balances.controller.member.dto.ChartBalanceVo;
import com.jdc.online.balances.controller.member.dto.ChartSummaryVo;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.service.MemberChartService;
import com.jdc.online.balances.utils.LoadType;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("member/chart")
public class MemberChartApi {
	
	private final MemberChartService service;

	@GetMapping("summary")
	ChartSummaryVo getSummaryData(@RequestParam(required = false, defaultValue = "Monthly") LoadType type) {
		return service.getSummaryData(type);
	}
	
	@GetMapping("balance")
	List<ChartBalanceVo> getBalanceData(@RequestParam(required = false, defaultValue = "Monthly") LoadType type) {
		return service.getBalanceData(type);
	}
	
	@GetMapping("ledger")
	Map<BalanceType, List<ChartAmountVo>> getLedgerData(@RequestParam(required = false, defaultValue = "Monthly") LoadType type) {
		return service.getLedgerData(type);
	}
}
