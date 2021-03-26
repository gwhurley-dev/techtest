package com.softwarehammer.blockone.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest
{
	private Student s;

	@BeforeEach
	void setUp() throws Exception
	{
		s = new Student();
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
	void testGetFirstName()
	{
		s.setFirstName("asd");
		
		assertEquals("asd", s.getFirstName());
	}

	@Test
	void testGetLastName()
	{
		s.setLastName("zxc");
		
		assertEquals("zxc", s.getLastName());
	}

	@Test
	void testGetNationality()
	{
		s.setNationality("qwe");
		
		assertEquals("qwe", s.getNationality());
	}

	@Test
	void testSetId()
	{
		s.setId(123);
		
		assertEquals(123, s.getId());
	}

	@Test
	void testSetFirstName()
	{
		s.setFirstName("asd");
		
		assertEquals("asd", s.getFirstName());
	}

	@Test
	void testSetLastName()
	{
		s.setLastName("zxc");
		
		assertEquals("zxc", s.getLastName());
	}

	@Test
	void testSetNationality()
	{
		s.setNationality("qwe");
		
		assertEquals("qwe", s.getNationality());
	}

	@Test
	void testToString()
	{
		s.setId(123);
		s.setFirstName("asd");
		s.setLastName("zxc");
		s.setNationality("qwe");
		
		String expected = "123:asd_zxc";
		
		assertEquals(expected, s.toString());
	}
}
