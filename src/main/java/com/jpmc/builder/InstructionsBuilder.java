package com.jpmc.builder;

import com.jpmc.model.Currency;
import com.jpmc.model.Instruction;
import com.jpmc.model.Type;

import java.util.Arrays;
import java.util.List;

import static com.jpmc.util.InstructionUtil.getLocalDate;

/*
	Build sample data here to test
 */
public class InstructionsBuilder
{
	Instruction instruction = Instruction.Builder.newInstance().withEntity("foo")
			.withCurrency(Currency.SGP)
			.withType(Type.OUTGOING)
			.withAgreedFx(0.50)
			.withInstructionDate(getLocalDate("19 Aug 2019"))
			.withSettlementDate(getLocalDate("20 Aug 2019"))
			.withUnits(200)
			.withPrice(100.25)
			.build();

	Instruction instruction1 = Instruction.Builder.newInstance().withEntity("bar")
			.withCurrency(Currency.AED)
			.withType(Type.INCOMING)
			.withAgreedFx(0.22)
			.withInstructionDate(getLocalDate("16 Aug 2019"))
			.withSettlementDate(getLocalDate("17 Aug 2019"))
			.withUnits(450)
			.withPrice(150.5)
			.build();

	Instruction instruction2 = Instruction.Builder.newInstance().withEntity("foo")
			.withCurrency(Currency.SGP)
			.withType(Type.INCOMING)
			.withAgreedFx(0.50)
			.withInstructionDate(getLocalDate("19 Aug 2019"))
			.withSettlementDate(getLocalDate("20 Aug 2019"))
			.withUnits(100)
			.withPrice(100.25)
			.build();

	Instruction instruction3 = Instruction.Builder.newInstance().withEntity("bar")
			.withCurrency(Currency.AED)
			.withType(Type.OUTGOING)
			.withAgreedFx(0.22)
			.withInstructionDate(getLocalDate("16 Aug 2019"))
			.withSettlementDate(getLocalDate("17 Aug 2019"))
			.withUnits(50)
			.withPrice(150.5)
			.build();

	Instruction instruction4 = Instruction.Builder.newInstance().withEntity("bar")
			.withCurrency(Currency.AED)
			.withType(Type.OUTGOING)
			.withAgreedFx(0.22)
			.withInstructionDate(getLocalDate("18 Aug 2019"))
			.withSettlementDate(getLocalDate("20 Aug 2019"))
			.withUnits(50)
			.withPrice(150.5)
			.build();

	Instruction instruction5 = Instruction.Builder.newInstance().withEntity("joo")
			.withCurrency(Currency.GBP)
			.withType(Type.OUTGOING)
			.withAgreedFx(0.50)
			.withInstructionDate(getLocalDate("09 Aug 2019"))
			.withSettlementDate(getLocalDate("10 Aug 2019"))
			.withUnits(200)
			.withPrice(100.25)
			.build();

	Instruction instruction6 = Instruction.Builder.newInstance().withEntity("joo")
			.withCurrency(Currency.GBP)
			.withType(Type.OUTGOING)
			.withAgreedFx(0.50)
			.withInstructionDate(getLocalDate("09 Aug 2019"))
			.withSettlementDate(getLocalDate("14 Aug 2019"))
			.withUnits(200)
			.withPrice(100.25)
			.build();
	// Add sample data as required in the list
	public List<Instruction> getSampleDate(){
		return Arrays.asList(instruction, instruction1, instruction2, instruction3, instruction4, instruction5, instruction6);
	}
}
