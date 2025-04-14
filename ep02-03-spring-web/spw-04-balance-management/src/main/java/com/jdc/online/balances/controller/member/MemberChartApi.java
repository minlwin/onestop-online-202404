package com.jdc.online.balances.controller.member;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.online.balances.controller.member.dto.ChartSummaryVo;
import com.jdc.online.balances.utils.LoadType;

@RestController
@RequestMapping("member/chart")
public class MemberChartApi {

	@GetMapping("summary")
	ChartSummaryVo getSummaryData(@RequestParam(required = false, defaultValue = "Monthly") LoadType type) {
		return switch(type) {
		case Monthly -> new ChartSummaryVo(BigDecimal.valueOf(500000), BigDecimal.valueOf(150000));
		case Yearly -> new ChartSummaryVo(BigDecimal.valueOf(2500000), BigDecimal.valueOf(300000));
		};
	}
}
