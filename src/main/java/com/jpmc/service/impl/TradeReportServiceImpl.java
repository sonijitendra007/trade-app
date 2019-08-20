package com.jpmc.service.impl;

import com.jpmc.app.InstructionApp;
import com.jpmc.app.impl.InstructionAppImpl;
import com.jpmc.exception.JpmcException;
import com.jpmc.model.DayTrade;
import com.jpmc.model.Instruction;
import com.jpmc.model.Type;
import com.jpmc.service.TradeReportService;

import java.util.*;
import java.util.stream.Collectors;

import static com.jpmc.util.InstructionUtil.getLocalDate;

public class TradeReportServiceImpl extends ServiceHelper implements TradeReportService
{
	@Override
	public List<DayTrade> getReportData(String sortBy, Optional<String> filterByDate)
	{
		if (!Type.isValid(sortBy)){
			throw new JpmcException("Type not valid");
		}
		return filterByDate.map(s -> getReportData(sortBy).stream().filter(p -> p.getSettlementDate().equals(getLocalDate(s)))
				.collect(Collectors.toList())).orElseGet(() -> getReportData(sortBy));
	}

	private List<DayTrade> getReportData(String sortBy)
	{
		InstructionApp app = new InstructionAppImpl();
		Map<String, List<DayTrade>> report = new HashMap<>();
		Map<String, List<Instruction>> listMap = app.getInstructions().stream()
				.collect(Collectors.groupingBy(Instruction::getEntity));
		listMap.forEach((key, value) -> value.forEach(p -> report.compute(p.getEntity(), (k, v) -> v != null ?
				updateDayTrade(v, p) : createDayTrade(p))
		));
		List<DayTrade> result = new ArrayList<>();
		report.values().forEach(result::addAll);
		return result.stream()
				.sorted(rankBySettlementType(sortBy))
				.collect(Collectors.toList());
	}
}
