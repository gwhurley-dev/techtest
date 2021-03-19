package com.softwarehammer.blockone.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softwarehammer.blockone.business.EnrollmentBO;
import com.softwarehammer.blockone.dao.CourseDao;
import com.softwarehammer.blockone.dao.EnrollmentDao;
import com.softwarehammer.blockone.entity.Course;
import com.softwarehammer.blockone.entity.Enrollment;

/**
 * REST operations for Enrollments
 */
@Controller
@EnableAutoConfiguration
public class EnrollmentController
{
	Logger logger = LoggerFactory.getLogger(EnrollmentController.class);
	
    private final EnrollmentDao enrollmentDao;
    
    private final CourseDao courseDao;
    
    private final EnrollmentBO enrollmentBO;

    public EnrollmentController(EnrollmentDao enrollmentDao, CourseDao courseDao, EnrollmentBO enrollmentBO)
    {
    	this.enrollmentDao = enrollmentDao;
    	this.courseDao = courseDao;
    	this.enrollmentBO = enrollmentBO;
    }
    
    /**
     * Returns all Courses that a Student has registered for the specified Semester.
     */
	@GetMapping("/api/enrollment/student/{studentId}/semester/{semesterId}")
    public ResponseEntity<List<Course>> getEnrolledClasses(@PathVariable Long studentId, @PathVariable Long semesterId)
	{
		List<Course> enrolled = enrollmentDao.getEnrolledCourses(studentId, semesterId);
		
		logger.info("Retrieved Enrolled Courses: StudentId: " + studentId + " SemesterId: " + semesterId + " Count: " + enrolled.size());
	
	    return new ResponseEntity<List<Course>>(enrolled, HttpStatus.OK);	
	}

	/**
	 * Returns all Courses that a Student has ever registered for.
	 */
	@GetMapping("/api/enrollment/student/{studentId}")
    public ResponseEntity<List<Course>> getEnrollmentHistory(@PathVariable Long studentId)
	{
		List<Course> enrolled = enrollmentDao.getEnrollmentHistory(studentId);
		
		logger.debug("Retrieved Enrollment History: StudentId: " + studentId);
	
	    return new ResponseEntity<List<Course>>(enrolled, HttpStatus.OK);	
	}

	@RequestMapping(value="/api/enrollment", method=RequestMethod.POST)
	@PostMapping
	(
        value = "/postbody",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<String> createCourse(@RequestBody Enrollment enrollment)
	{
		int currentCredits = enrollmentDao.getCredits(enrollment);
		int additionalCredits = courseDao.getById(enrollment.getCourse().getId()).getCredits();
		
		if (enrollmentBO.isMaxCredits(currentCredits + additionalCredits))
		{
			logger.debug("Enrollment request would exceeed maximum credit hours: " + enrollment);
		    return new ResponseEntity<>("This enrollment would exceed maximum credit hours.", HttpStatus.CONFLICT);	
		}
		
		enrollmentDao.create(enrollment);
		
		logger.info("Created Enrollment record: " + enrollment);
		
	    return new ResponseEntity<>(HttpStatus.CREATED);	
    }

	@DeleteMapping("/api/enrollment/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id)
	{
		enrollmentDao.delete(id);
		
		logger.info("Deleted Enrollment record: " + id);
	
	    return new ResponseEntity<>(HttpStatus.OK);	
	}
}
