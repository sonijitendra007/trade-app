package com.jpmc.service;

import com.jpmc.model.DayTrade;

import java.util.List;
import java.util.Optional;

/*
 * Service to get trade report
 */
public interface TradeReportService
{
	/**
	 * @param sortBy type of sorting
	 * @param sortBy optional filter data by a date
	 * @return list of DayTrade
	 */
	 List<DayTrade> getReportData(String sortBy, Optional<String> filterByDate);
}
