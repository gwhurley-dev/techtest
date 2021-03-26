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

import com.softwarehammer.blockone.dao.CourseDao;
import com.softwarehammer.blockone.entity.Course;

import nl.altindag.log.LogCaptor;

class CourseControllerTest
{
	private CourseController cc;
	private CourseDao courseDao;
	
	@BeforeEach
	void setUp() throws Exception
	{
		courseDao = mock(CourseDao.class);
		cc = new CourseController(courseDao);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetCourse()
	{
		ResponseEntity<Course> expected = new ResponseEntity<Course>(new Course(), HttpStatus.OK);
		
		LogCaptor logCaptor = LogCaptor.forClass(CourseController.class);
		logCaptor.setLogLevelToTrace();
		
		when(courseDao.getById(5l)).thenReturn(new Course());		
		ResponseEntity<Course> response = cc.getCourse(5l);

		assertEquals(expected, response);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
		
		ResponseEntity<Course> expected2 = new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		when(courseDao.getById(5l)).thenReturn(null);
		response = cc.getCourse(5l);

		assertEquals(expected2, response);
	}

	@Test
	void testCreateCourse()
	{
		Course c = new Course();
		
		LogCaptor logCaptor = LogCaptor.forClass(CourseController.class);
		logCaptor.setLogLevelToTrace();

		cc.createCourse(c);
		
		verify(courseDao, times(1)).create(c);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

	@Test
	void testUpdateCourse()
	{
		Course c = new Course();
		
		LogCaptor logCaptor = LogCaptor.forClass(CourseController.class);
		logCaptor.setLogLevelToTrace();

		cc.updateCourse(c);
		
		verify(courseDao, times(1)).update(c);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

	@Test
	void testDeleteCourse()
	{
		LogCaptor logCaptor = LogCaptor.forClass(CourseController.class);
		logCaptor.setLogLevelToTrace();

		cc.deleteCourse(5l);
		
		verify(courseDao, times(1)).delete(5l);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

}
