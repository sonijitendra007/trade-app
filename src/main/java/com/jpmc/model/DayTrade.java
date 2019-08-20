package com.jpmc.model;

import java.time.LocalDate;


public class DayTrade
{
	private LocalDate settlementDate;
	private String entity;
	private Double incomingAmount;
	private Double outgoingAmount;

	public Double getIncomingAmount()
	{
		return incomingAmount;
	}

	public void setIncomingAmount(Double incomingAmount)
	{
		this.incomingAmount = incomingAmount;
	}

	public Double getOutgoingAmount()
	{
		return outgoingAmount;
	}

	public void setOutgoingAmount(Double outgoingAmount)
	{
		this.outgoingAmount = outgoingAmount;
	}

	public String getEntity()
	{
		return entity;
	}

	public void setEntity(String entity)
	{
		this.entity = entity;
	}

	public LocalDate getSettlementDate()
	{
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate)
	{
		this.settlementDate = settlementDate;
	}

	@Override
	public String toString()
	{
		return settlementDate +
				"        " + entity +
				"        " + incomingAmount +
				"        " + outgoingAmount + "\n";
	}
}
