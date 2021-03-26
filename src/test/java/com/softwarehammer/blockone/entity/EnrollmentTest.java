package com.softwarehammer.blockone.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnrollmentTest
{
	private Enrollment e;
	private Student student;
	private Semester semester;
	private Course course;
	
	@BeforeEach
	void setUp() throws Exception
	{
		e = new Enrollment();
		student = new Student();
		semester = new Semester();
		course = new Course();
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetId()
	{
		e.setId(123);
		
		assertEquals(123, e.getId());
	}

	@Test
	void testGetStudent()
	{
		e.setStudent(student);
		
		assertEquals(student, e.getStudent());
	}

	@Test
	void testGetCourse()
	{
		e.setCourse(course);
		
		assertEquals(course, e.getCourse());
	}

	@Test
	void testGetSemester()
	{
		e.setSemester(semester);
		
		assertEquals(semester, e.getSemester());
	}

	@Test
	void testSetId()
	{
		e.setId(123);
		
		assertEquals(123, e.getId());
	}

	@Test
	void testSetStudent()
	{
		e.setStudent(student);
		
		assertEquals(student, e.getStudent());
	}

	@Test
	void testSetCourse()
	{
		e.setCourse(course);
		
		assertEquals(course, e.getCourse());
	}

	@Test
	void testSetSemester()
	{
		e.setSemester(semester);
		
		assertEquals(semester, e.getSemester());
	}

}
