package com.jpmc.app.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class InstructionAppImplTest
{
	@InjectMocks
	private InstructionAppImpl testee;

	@Test
	public void shouldGetInstructions()
	{
		assertThat(testee.getInstructions(), is(notNullValue()));
	}
}
