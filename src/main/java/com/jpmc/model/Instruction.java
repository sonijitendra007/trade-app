package com.jpmc.model;

import java.time.LocalDate;

public class Instruction
{
	private String entity;
	private Type type;
	private Double agreedFx;
	private Currency currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private Integer units;
	private Double price;

	public String getEntity()
	{
		return entity;
	}

	public Type getType()
	{
		return type;
	}

	public Double getAgreedFx()
	{
		return agreedFx;
	}

	public Currency getCurrency()
	{
		return currency;
	}

	public LocalDate getInstructionDate()
	{
		return instructionDate;
	}

	public LocalDate getSettlementDate()
	{
		return settlementDate;
	}

	public Integer getUnits()
	{
		return units;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setEntity(String entity)
	{
		this.entity = entity;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public void setAgreedFx(Double agreedFx)
	{
		this.agreedFx = agreedFx;
	}

	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}

	public void setInstructionDate(LocalDate instructionDate)
	{
		this.instructionDate = instructionDate;
	}

	public void setSettlementDate(LocalDate settlementDate)
	{
		this.settlementDate = settlementDate;
	}

	public void setUnits(Integer units)
	{
		this.units = units;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}


	public static final class Builder
	{
		private String entity;
		private Type type;
		private Double agreedFx;
		private Currency currency;
		private LocalDate instructionDate;
		private LocalDate settlementDate;
		private Integer units;
		private Double price;

		private Builder()
		{
		}

		public static Builder newInstance()
		{
			return new Builder();
		}

		public Builder withEntity(String entity)
		{
			this.entity = entity;
			return this;
		}

		public Builder withType(Type type)
		{
			this.type = type;
			return this;
		}

		public Builder withAgreedFx(Double agreedFx)
		{
			this.agreedFx = agreedFx;
			return this;
		}

		public Builder withCurrency(Currency currency)
		{
			this.currency = currency;
			return this;
		}

		public Builder withInstructionDate(LocalDate instructionDate)
		{
			this.instructionDate = instructionDate;
			return this;
		}

		public Builder withSettlementDate(LocalDate settlementDate)
		{
			this.settlementDate = settlementDate;
			return this;
		}

		public Builder withUnits(Integer units)
		{
			this.units = units;
			return this;
		}

		public Builder withPrice(Double price)
		{
			this.price = price;
			return this;
		}

		public Instruction build()
		{
			Instruction instruction = new Instruction();
			instruction.setEntity(entity);
			instruction.setType(type);
			instruction.setAgreedFx(agreedFx);
			instruction.setCurrency(currency);
			instruction.setInstructionDate(instructionDate);
			instruction.setSettlementDate(settlementDate);
			instruction.setUnits(units);
			instruction.setPrice(price);
			return instruction;
		}
	}
}
