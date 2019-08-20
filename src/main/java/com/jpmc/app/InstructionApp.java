package com.jpmc.app;

import com.jpmc.model.Instruction;

import java.util.List;

/*
 * Interface to get Instructions
 */
public interface InstructionApp
{
	/**
	 * @return list of Instructions
	 */
	List<Instruction> getInstructions();
}
