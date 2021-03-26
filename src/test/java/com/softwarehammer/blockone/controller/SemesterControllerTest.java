package com.softwarehammer.blockone.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.softwarehammer.blockone.dao.SemesterDao;
import com.softwarehammer.blockone.entity.Semester;

import nl.altindag.log.LogCaptor;

class SemesterControllerTest
{
	private SemesterController sc;
	private SemesterDao semesterDao;
	

	@BeforeEach
	void setUp() throws Exception
	{
		semesterDao = mock(SemesterDao.class);
		sc = new SemesterController(semesterDao);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetSemester()
	{
		ResponseEntity<Semester> expected = new ResponseEntity<Semester>(new Semester(), HttpStatus.OK);
		
		LogCaptor logCaptor = LogCaptor.forClass(SemesterController.class);
		logCaptor.setLogLevelToTrace();
		
		when(semesterDao.getById(5l)).thenReturn(new Semester());		
		ResponseEntity<Semester> response = sc.getSemester(5l);

		assertEquals(expected, response);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
		
		ResponseEntity<Semester> expected2 = new ResponseEntity<Semester>(HttpStatus.NOT_FOUND);
		when(semesterDao.getById(5l)).thenReturn(null);
		response = sc.getSemester(5l);

		assertEquals(expected2, response);
	}

	@Test
	void testCreateSemester()
	{
		Semester s = new Semester();
		
		LogCaptor logCaptor = LogCaptor.forClass(SemesterController.class);
		logCaptor.setLogLevelToTrace();

		sc.createSemester(s);
		
		verify(semesterDao, times(1)).create(s);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

	@Test
	void testUpdateSemester()
	{
		Semester s = new Semester();
		
		LogCaptor logCaptor = LogCaptor.forClass(SemesterController.class);
		logCaptor.setLogLevelToTrace();

		sc.updateSemester(s);
		
		verify(semesterDao, times(1)).update(s);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

	@Test
	void testDeleteSemester()
	{
		LogCaptor logCaptor = LogCaptor.forClass(SemesterController.class);
		logCaptor.setLogLevelToTrace();

		sc.deleteSemester(5l);
		
		verify(semesterDao, times(1)).delete(5l);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

}
