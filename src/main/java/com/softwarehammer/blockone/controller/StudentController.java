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

import com.softwarehammer.blockone.dao.StudentDao;
import com.softwarehammer.blockone.entity.Student;

@Controller
@EnableAutoConfiguration
public class StudentController
{
	Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao)
    {
    	this.studentDao = studentDao;
    }
    
	@GetMapping("/api/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
	{
		Student student = studentDao.getById(id);
		
		logger.debug("Retrieved student record: " + student);
	
		if (student != null) {
	        return new ResponseEntity<Student>(student, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}

	@RequestMapping(value="/api/student", method=RequestMethod.POST)
	@PostMapping
	(
        value = "/postbody",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<String> createStudent(@RequestBody Student student)
	{
		studentDao.create(student);
		
		logger.info("Created student record: " + student);
		
	    return new ResponseEntity<>(HttpStatus.CREATED);	
    }

	@RequestMapping(value="/api/student", method=RequestMethod.PUT)
	@PutMapping
	(
        value = "/putbody",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<String> updateStudent(@RequestBody Student student)
	{
		studentDao.update(student);
		
		logger.info("Updated student record: " + student);
		
	    return new ResponseEntity<>(HttpStatus.OK);	
    }

	@DeleteMapping("/api/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
	{
		studentDao.delete(id);
		
		logger.debug("Deleted student record: " + id);
	
	    return new ResponseEntity<>(HttpStatus.OK);	
	}
}
