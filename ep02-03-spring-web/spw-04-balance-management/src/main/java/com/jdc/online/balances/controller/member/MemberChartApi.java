package com.jdc.online.balances.controller.member;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.online.balances.controller.member.dto.ChartAmountVo;
import com.jdc.online.balances.controller.member.dto.ChartBalanceVo;
import com.jdc.online.balances.controller.member.dto.ChartSummaryVo;
import com.jdc.online.balances.model.entity.consts.BalanceType;
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
	
	@GetMapping("balance")
	List<ChartBalanceVo> getBalanceData(@RequestParam(required = false, defaultValue = "Monthly") LoadType type) {
		Supplier<BigDecimal> generator = () -> BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(999999));
		return IntStream.iterate(1, a -> a + 1)
				.limit(10)
				.mapToObj(a -> new ChartBalanceVo(
						LocalDate.now().minusDays(10).plusDays(a), 
						generator.get(),
						generator.get()))
				.toList();
	}
	
	@GetMapping("ledger")
	Map<BalanceType, List<ChartAmountVo>> getLedgerData(@RequestParam(required = false, defaultValue = "Monthly") LoadType type) {
		var map = new HashMap<BalanceType, List<ChartAmountVo>>();
		Supplier<BigDecimal> generator = () -> BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(999999));
		
		map.put(BalanceType.Incomes, 
				IntStream.iterate(1, a -> a + 1).limit(5)
					.mapToObj(a -> new ChartAmountVo("Income %d".formatted(a), generator.get()))
					.toList());
		
		map.put(BalanceType.Expenses, 
				IntStream.iterate(1, a -> a + 1).limit(5)
					.mapToObj(a -> new ChartAmountVo("Expense %d".formatted(a), generator.get()))
					.toList());

		return map;
	}
}
