package com.softwarehammer.blockone.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softwarehammer.blockone.entity.Semester;

class SemesterDaoTest
{
	private SemesterDao d;
	private SqlSession session;

	@BeforeEach
	void setUp() throws Exception
	{
		session = mock(SqlSession.class);
		d = new SemesterDao(session);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetById()
	{
		d.getById(5l);
		
		verify(session, times(1)).selectOne("getSemesterById", 5l);
	}

	@Test
	void testCreate()
	{
		Semester s = new Semester();
		
		d.create(s);
		
		verify(session, times(1)).insert("createSemester", s);
	}

	@Test
	void testUpdate()
	{
		Semester s = new Semester();
		
		d.update(s);
		
		verify(session, times(1)).update("updateSemester", s);
	}

	@Test
	void testDelete()
	{
		d.delete(5l);
		
		verify(session, times(1)).delete("deleteSemester", 5l);
	}

}
