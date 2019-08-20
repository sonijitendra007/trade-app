package com.jpmc;

import com.jpmc.service.TradeReportService;
import com.jpmc.service.impl.TradeReportServiceImpl;

import java.util.Optional;
import java.util.Scanner;


/**
 * Application Runner for the project trade-app
 */
public class ApplicationRunner
{
	public static void main(String[] args)
	{
		TradeReportService service = new TradeReportServiceImpl();
		System.out.println("================================Trade Report=================================");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Sorting Type for Report (INCOMING/OUTGOING):: ");
		String sortType = scanner.nextLine();
		System.out.println("Enter Date (format dd MMM yyy, e.g 01 Aug 2019) for the report (Optional) :: ");
		String filterDate = scanner.nextLine();
		System.out.println("settlementDate" + "    entity" + "    incomingAmount" + "    outgoingAmount");
		System.out.println("============================================================================");
		if (filterDate.isEmpty())
		{
			// Use below if wants to generate report for all the dates
			System.out.println(service.getReportData(sortType, Optional.empty()));
		}
		else
		{
			// Use below if wants to generate report only for specific date
			System.out.println(service.getReportData(sortType, Optional.of(filterDate)));
		}
	}
}
