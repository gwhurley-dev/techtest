package com.softwarehammer.blockone.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SemesterTest
{
	private Semester s;
	
	@BeforeEach
	void setUp() throws Exception
	{
		s = new Semester();
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetId()
	{
		s.setId(123);
		
		assertEquals(123, s.getId());
	}

	@Test
	void testGetYear()
	{
		s.setYear(234);
		
		assertEquals(234, s.getYear());
	}

	@Test
	void testGetSemester()
	{
		s.setSemester(345);
		
		assertEquals(345, s.getSemester());
	}

	@Test
	void testSetId()
	{
		s.setId(123);
		
		assertEquals(123, s.getId());
	}

	@Test
	void testSetYear()
	{
		s.setYear(234);
		
		assertEquals(234, s.getYear());
	}

	@Test
	void testSetSemester()
	{
		s.setSemester(345);
		
		assertEquals(345, s.getSemester());
	}

}
