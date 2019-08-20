package com.jpmc.service.impl;

import com.jpmc.model.DayTrade;
import com.jpmc.model.Instruction;
import com.jpmc.model.Type;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jpmc.util.InstructionUtil.calculateTradeAmountInUSD;
import static java.util.Arrays.asList;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;

public class ServiceHelper
{
	protected List<DayTrade> updateDayTrade(List<DayTrade> dayTrades, Instruction ins)
	{
		List<DayTrade> withSettlementDate = dayTrades.stream()
				.filter(trade -> trade.getSettlementDate().equals(ins.getSettlementDate())).collect(
						Collectors.toList());
		if (!withSettlementDate.isEmpty())
		{
			withSettlementDate.forEach(dayTrade -> {
				if (ins.getType() == Type.INCOMING)
				{
					dayTrade.setIncomingAmount(dayTrade.getIncomingAmount() != null ?
							dayTrade.getIncomingAmount() + calculateTradeAmountInUSD(ins.getPrice(), ins.getUnits(), ins.getAgreedFx())
							: calculateTradeAmountInUSD(ins.getPrice(), ins.getUnits(), ins.getAgreedFx()));
				}
				if (ins.getType() == Type.OUTGOING)
				{
					dayTrade.setOutgoingAmount(dayTrade.getOutgoingAmount() != null ?
							dayTrade.getOutgoingAmount() + calculateTradeAmountInUSD(ins.getPrice(), ins.getUnits(), ins.getAgreedFx())
							: calculateTradeAmountInUSD(ins.getPrice(), ins.getUnits(), ins.getAgreedFx()));
				}
			});
			return withSettlementDate;
		}
		return Stream.of(dayTrades, createDayTrade(ins))
				.flatMap(Collection::stream).collect(Collectors.toList());
	}

	protected List<DayTrade> createDayTrade(Instruction ins)
	{
		DayTrade dayTrade = new DayTrade();
		dayTrade.setSettlementDate(ins.getSettlementDate());
		dayTrade.setEntity(ins.getEntity());
		if (ins.getType() == Type.INCOMING)
		{
			dayTrade.setIncomingAmount(
					calculateTradeAmountInUSD(ins.getPrice(), ins.getUnits(), ins.getAgreedFx()));
		}
		if (ins.getType() == Type.OUTGOING)
		{
			dayTrade.setOutgoingAmount(
					calculateTradeAmountInUSD(ins.getPrice(), ins.getUnits(), ins.getAgreedFx()));
		}
		return asList(dayTrade);
	}

	protected Comparator<DayTrade> rankBySettlementType(String sortBy)
	{
		if (sortBy.equals(Type.INCOMING.toString()))
		{
			return Comparator.comparing(DayTrade::getSettlementDate, reverseOrder())
					.thenComparing(DayTrade::getIncomingAmount, nullsLast(reverseOrder()));
		}
		return Comparator.comparing(DayTrade::getSettlementDate, reverseOrder())
				.thenComparing(DayTrade::getOutgoingAmount, nullsLast(reverseOrder()));
	}
}
