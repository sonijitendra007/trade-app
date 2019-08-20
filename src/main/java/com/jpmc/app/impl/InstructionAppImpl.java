package com.jpmc.app.impl;

import com.jpmc.app.InstructionApp;
import com.jpmc.builder.InstructionsBuilder;
import com.jpmc.model.Instruction;

import java.util.List;

import static com.jpmc.util.InstructionUtil.getSettlementDateBasedOnCurrency;

public class InstructionAppImpl implements InstructionApp
{
	@Override
	public List<Instruction> getInstructions()
	{
		List<Instruction> instructions = new InstructionsBuilder().getSampleDate();
		instructions.forEach(p -> p.setSettlementDate(getSettlementDateBasedOnCurrency(p.getSettlementDate(), p.getCurrency())));
		return instructions;
	}
}
