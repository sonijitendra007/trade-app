package com.jpmc.service.impl;

import com.jpmc.exception.JpmcException;
import com.jpmc.model.DayTrade;
import com.jpmc.util.InstructionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TradeReportServiceImplTest
{
	@InjectMocks
	private TradeReportServiceImpl testee;

	@Test
	public void shouldGetReportData()
	{
		List<DayTrade> trades = testee.getReportData("INCOMING", Optional.of("14 Aug 2019"));
		assertThat(trades.size(), is(equalTo(1)));
		assertThat(trades.get(0).getEntity(), is(equalTo("joo")));
		assertThat(trades.get(0).getSettlementDate(), is(equalTo(InstructionUtil.getLocalDate("14 Aug 2019"))));
		assertThat(trades.get(0).getIncomingAmount(), is(nullValue()));
		assertThat(trades.get(0).getOutgoingAmount(), is(equalTo(10025.0)));
	}

	@Test(expected = JpmcException.class)
	public void shouldThrowExceptionWhenInvalidType()
	{
		testee.getReportData("abc", Optional.of("14 Aug 2019"));
	}

	@Test(expected = JpmcException.class)
	public void shouldThrowExceptionWhenInvalidDate()
	{
		testee.getReportData("INCOMING", Optional.of("54 Aug 2019"));
	}
}
