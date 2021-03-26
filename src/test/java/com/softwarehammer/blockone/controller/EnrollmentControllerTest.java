package com.softwarehammer.blockone.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.softwarehammer.blockone.business.EnrollmentBO;
import com.softwarehammer.blockone.dao.CourseDao;
import com.softwarehammer.blockone.dao.EnrollmentDao;
import com.softwarehammer.blockone.entity.Course;
import com.softwarehammer.blockone.entity.Enrollment;

class EnrollmentControllerTest
{
	private EnrollmentController ec;
	
	private EnrollmentDao enrollmentDao;
	private CourseDao courseDao;
	private EnrollmentBO enrollmentBO;
	private Enrollment enrollment;
	private Course course;
	
	@BeforeEach
	void setUp() throws Exception
	{
		enrollmentDao = mock(EnrollmentDao.class);
		courseDao = mock(CourseDao.class);
		enrollmentBO = mock(EnrollmentBO.class);
		course = new Course();
		course.setId(1l);
		course.setCredits(2);
		enrollment = new Enrollment();
		enrollment.setCourse(course);
		
		ec = new EnrollmentController(enrollmentDao, courseDao, enrollmentBO);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testGetEnrolledClasses()
	{
		List<Course> enrolled = new ArrayList<Course>();		
		when(enrollmentDao.getEnrolledCourses(1l,2l)).thenReturn(enrolled);
		
		ResponseEntity<List<Course>> expected = new ResponseEntity<List<Course>>(enrolled, HttpStatus.OK);
		
		assertEquals(expected, ec.getEnrolledClasses(1l,2l));
	}

	@Test
	void testGetEnrollmentHistory()
	{
		List<Course> enrolled = new ArrayList<Course>();		
		when(enrollmentDao.getEnrolledCourses(1l,2l)).thenReturn(enrolled);
		
		ResponseEntity<List<Course>> expected = new ResponseEntity<List<Course>>(enrolled, HttpStatus.OK);
		
		assertEquals(expected, ec.getEnrollmentHistory(1l));
	}

	@Test
	void testCreateCourseSucceed()
	{
		when(enrollmentDao.getCredits(enrollment)).thenReturn(1);
		when(courseDao.getById(1l)).thenReturn(course);
		when(enrollmentBO.isMaxCredits(3)).thenReturn(false);

		ResponseEntity<String> response = ec.createCourse(enrollment);
		
		verify(enrollmentBO, times(1)).isMaxCredits(3);
		verify(enrollmentDao, times(1)).create(enrollment);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void testCreateCourseFail()
	{
		when(enrollmentDao.getCredits(enrollment)).thenReturn(5);
		when(courseDao.getById(1l)).thenReturn(course);
		when(enrollmentBO.isMaxCredits(7)).thenReturn(true);

		ResponseEntity<String> response = ec.createCourse(enrollment);
		
		verify(enrollmentBO, times(1)).isMaxCredits(7);

		assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
	}

	@Test
	void testDeleteCourse()
	{
		ResponseEntity<String> response = ec.deleteCourse(1l);
		
		verify(enrollmentDao, times(1)).delete(1l);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
