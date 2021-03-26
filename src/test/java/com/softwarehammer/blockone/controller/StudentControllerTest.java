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

import com.softwarehammer.blockone.dao.StudentDao;
import com.softwarehammer.blockone.entity.Student;

import nl.altindag.log.LogCaptor;

class StudentControllerTest
{
	private StudentController cc;
	private StudentDao studentDao;
	
	@BeforeEach
	void setUp() throws Exception
	{
		studentDao = mock(StudentDao.class);
		cc = new StudentController(studentDao);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetStudent()
	{
		ResponseEntity<Student> expected = new ResponseEntity<Student>(new Student(), HttpStatus.OK);
		
		LogCaptor logCaptor = LogCaptor.forClass(StudentController.class);
		logCaptor.setLogLevelToTrace();
		
		when(studentDao.getById(5l)).thenReturn(new Student());		
		ResponseEntity<Student> response = cc.getStudent(5l);

		assertEquals(expected, response);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
		
		ResponseEntity<Student> expected2 = new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		when(studentDao.getById(5l)).thenReturn(null);
		response = cc.getStudent(5l);

		assertEquals(expected2, response);
	}

	@Test
	void testCreateStudent()
	{
		Student s = new Student();
		
		LogCaptor logCaptor = LogCaptor.forClass(StudentController.class);
		logCaptor.setLogLevelToTrace();

		cc.createStudent(s);
		
		verify(studentDao, times(1)).create(s);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

	@Test
	void testUpdateStudent()
	{
		Student s = new Student();
		
		LogCaptor logCaptor = LogCaptor.forClass(StudentController.class);
		logCaptor.setLogLevelToTrace();

		cc.updateStudent(s);
		
		verify(studentDao, times(1)).update(s);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

	@Test
	void testDeleteStudent()
	{
		LogCaptor logCaptor = LogCaptor.forClass(StudentController.class);
		logCaptor.setLogLevelToTrace();

		cc.deleteStudent(5l);
		
		verify(studentDao, times(1)).delete(5l);
		
		List<String> logs = logCaptor.getLogs();		  
		assertThat(logs, hasSize(1));
	}

}
