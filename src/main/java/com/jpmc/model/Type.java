package com.jpmc.model;


public enum Type
{
	OUTGOING("B"),
	INCOMING("S");

	private String value;

	Type(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public static boolean isValid(String value)
	{
		for (Type type : Type.values())
		{
			if (value.equals(type.toString()))
				return true;
		}
		return false;
	}
}
