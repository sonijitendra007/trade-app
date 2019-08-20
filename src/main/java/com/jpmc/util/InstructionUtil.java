package com.jpmc.util;

import com.jpmc.exception.JpmcException;
import com.jpmc.model.Currency;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InstructionUtil
{
	public static LocalDate getLocalDate(String date)
	{
		try
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
			return LocalDate.parse(date, formatter);
		}
		catch (Exception exp)
		{
			throw new JpmcException("Exception occurred while paring the date");
		}
	}

	public static LocalDate getSettlementDateBasedOnCurrency(LocalDate settlementDate, Currency currency)
	{
		if (currency == Currency.SAR || currency == Currency.AED)
		{
			if (settlementDate.getDayOfWeek() == DayOfWeek.FRIDAY)
			{
				return settlementDate.plusDays(2);
			}
			if (settlementDate.getDayOfWeek() == DayOfWeek.SATURDAY)
			{
				return settlementDate.plusDays(1);
			}
		}
		else
		{
			if (settlementDate.getDayOfWeek() == DayOfWeek.SATURDAY)
			{
				return settlementDate.plusDays(2);
			}
			if (settlementDate.getDayOfWeek() == DayOfWeek.SUNDAY)
			{
				return settlementDate.plusDays(1);
			}
		}
		return settlementDate;
	}

	public static double calculateTradeAmountInUSD(Double price, int units, Double agreedFx)
	{
		return price * units * agreedFx;
	}
}
