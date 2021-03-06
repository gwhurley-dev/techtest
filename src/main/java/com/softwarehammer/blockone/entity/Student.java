package com.softwarehammer.blockone.entity;

import lombok.Data;

@Data
public class Student
{
	private int id;
	private String firstName;
	private String lastName;
	private String nationality;
	
	@Override
	public String toString()
	{
		return id + ":" + firstName + "_" + lastName;
	}
}
