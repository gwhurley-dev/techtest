package com.softwarehammer.blockone.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnrollmentBOTest
{
	private EnrollmentBO b;
	
	@BeforeEach
	void setUp() throws Exception
	{
		b = new EnrollmentBO();
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testIsMaxCredits()
	{
		assertTrue(b.isMaxCredits(21));
	}

	@Test
	void testIsMaxCredits2()
	{
		assertTrue(!b.isMaxCredits(19));
	}
}
