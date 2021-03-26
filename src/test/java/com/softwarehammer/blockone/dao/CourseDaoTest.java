package com.softwarehammer.blockone.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softwarehammer.blockone.entity.Course;

class CourseDaoTest
{
	private CourseDao d;
	private SqlSession session;

	@BeforeEach
	void setUp() throws Exception
	{
		session = mock(SqlSession.class);
		d = new CourseDao(session);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetById()
	{
		d.getById(5l);
		
		verify(session, times(1)).selectOne("getCourseById", 5l);
	}

	@Test
	void testCreate()
	{
		Course c = new Course();
		
		d.create(c);
		
		verify(session, times(1)).insert("createCourse", c);
	}

	@Test
	void testUpdate()
	{
		Course c = new Course();
		
		d.update(c);
		
		verify(session, times(1)).update("updateCourse", c);
	}

	@Test
	void testDelete()
	{
		d.delete(5l);
		
		verify(session, times(1)).delete("deleteCourse", 5l);
	}

}
