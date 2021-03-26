package com.softwarehammer.blockone.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest
{
	private Course c;

	@BeforeEach
	void setUp() throws Exception
	{
		c = new Course();
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetId()
	{
		c.setId(123);
		
		assertEquals(123, c.getId());
	}

	@Test
	void testGetCode()
	{
		c.setCode("abc");
		
		assertEquals("abc", c.getCode());
	}

	@Test
	void testGetCredits()
	{
		c.setCredits(5);
		
		assertEquals(5, c.getCredits());
	}

	@Test
	void testSetId()
	{
		c.setId(123);
		
		assertEquals(123, c.getId());
	}

	@Test
	void testSetCode()
	{
		c.setCode("abc");
		
		assertEquals("abc", c.getCode());
	}

	@Test
	void testSetCredits()
	{
		c.setCredits(5);
		
		assertEquals(5, c.getCredits());
	}

}
