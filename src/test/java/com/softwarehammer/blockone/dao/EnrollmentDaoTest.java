package com.softwarehammer.blockone.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softwarehammer.blockone.entity.Enrollment;

class EnrollmentDaoTest
{
	private EnrollmentDao d;
	private SqlSession session;
	private Enrollment enrollment;
	
	@BeforeEach
	void setUp() throws Exception
	{
		session = mock(SqlSession.class);
		d = new EnrollmentDao(session);
		enrollment = new Enrollment();
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetCredits()
	{
		when(session.selectOne("getCredits", enrollment)).thenReturn(3);
		d.getCredits(enrollment);
		
		verify(session, times(1)).selectOne("getCredits", enrollment);
	}

	@Test
	void testCreate()
	{
		d.create(enrollment);
		
		verify(session, times(1)).insert("createEnrollment", enrollment);
	}

	@Test
	void testGetEnrolledCourses()
	{
		HashMap<String, Long> map = new HashMap<String, Long>();
		map.put("studentId", 5l);
		map.put("semesterId", 6l);
		
		d.getEnrolledCourses(5l, 6l);
		
		verify(session, times(1)).selectList("getEnrolledCourses", map);
	}

	@Test
	void testGetEnrollmentHistory()
	{
		d.getEnrollmentHistory(4l);
		
		verify(session, times(1)).selectList("getEnrollmentHistory", 4l);
	}

	@Test
	void testDelete()
	{
		d.delete(5l);
		
		verify(session, times(1)).delete("deleteEnrollment", 5l);
	}

}
