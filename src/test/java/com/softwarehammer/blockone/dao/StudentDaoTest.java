package com.softwarehammer.blockone.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softwarehammer.blockone.entity.Student;

class StudentDaoTest
{
	private StudentDao d;
	private SqlSession session;
	
	@BeforeEach
	void setUp() throws Exception
	{
		session = mock(SqlSession.class);
		d = new StudentDao(session);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetById()
	{
		d.getById(5l);
		
		verify(session, times(1)).selectOne("getStudentById", 5l);
	}

	@Test
	void testCreate()
	{
		Student s = new Student();
		
		d.create(s);
		
		verify(session, times(1)).insert("createStudent", s);
	}

	@Test
	void testUpdate()
	{
		Student s = new Student();
		
		d.update(s);
		
		verify(session, times(1)).update("updateStudent", s);
	}

	@Test
	void testDelete()
	{
		d.delete(5l);
		
		verify(session, times(1)).delete("deleteStudent", 5l);
	}

}
