package com.softwarehammer.blockone.controller;


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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softwarehammer.blockone.dao.CourseDao;
import com.softwarehammer.blockone.entity.Course;

@Controller
@EnableAutoConfiguration
public class CourseController
{
	Logger logger = LoggerFactory.getLogger(CourseController.class);
	
    private final CourseDao courseDao;

    public CourseController(CourseDao courseDao)
    {
    	this.courseDao = courseDao;
    }
    
	@GetMapping("/api/course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id)
	{
		Course course = courseDao.getById(id);
		
		logger.debug("Retrieved Course record: " + course);
	
		if (course != null) {
	        return new ResponseEntity<Course>(course, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}

	@RequestMapping(value="/api/course", method=RequestMethod.POST)
	@PostMapping
	(
        value = "/postbody",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<String> createCourse(@RequestBody Course course)
	{
		courseDao.create(course);
		
		logger.info("Created Course record: " + course);
		
	    return new ResponseEntity<>(HttpStatus.CREATED);	
    }

	@RequestMapping(value="/api/course", method=RequestMethod.PUT)
	@PutMapping
	(
        value = "/putbody",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<String> updateCourse(@RequestBody Course course)
	{
		courseDao.update(course);
		
		logger.info("Updated Course record: " + course);
		
	    return new ResponseEntity<>(HttpStatus.OK);	
    }

	@DeleteMapping("/api/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id)
	{
		courseDao.delete(id);
		
		logger.debug("Deleted Course record: " + id);
	
	    return new ResponseEntity<>(HttpStatus.OK);	
	}
}
