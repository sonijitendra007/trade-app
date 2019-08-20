package com.jpmc;

import com.jpmc.model.Type;
import com.jpmc.service.TradeReportService;
import com.jpmc.service.impl.TradeReportServiceImpl;

import java.util.Optional;


/**
 * Application Runner for the project trade-app
 */
public class ApplicationRunner
{
	public static void main(String[] args)
	{
		TradeReportService service = new TradeReportServiceImpl();
		// Use below if wants to generate report for all the dates
		System.out.println(service.getReportData(Type.INCOMING.toString(),Optional.empty()));

		// Use below if wants to generate report only for specific date
		System.out.println(service.getReportData(Type.INCOMING.toString(),Optional.of("50 Aug 2019")));
	}
}
