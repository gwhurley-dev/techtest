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

import com.softwarehammer.blockone.dao.SemesterDao;
import com.softwarehammer.blockone.entity.Semester;

/**
 * REST operations for Semesters.
 */
@Controller
@EnableAutoConfiguration
public class SemesterController
{
	Logger logger = LoggerFactory.getLogger(SemesterController.class);
	
    private final SemesterDao semesterDao;

    public SemesterController(SemesterDao semesterDao)
    {
    	this.semesterDao = semesterDao;
    }
    
	@GetMapping("/api/semester/{id}")
    public ResponseEntity<Semester> getSemester(@PathVariable Long id)
	{
		Semester semester = semesterDao.getById(id);
		
		logger.debug("Retrieved Semester record: " + semester);
	
		if (semester != null) {
	        return new ResponseEntity<Semester>(semester, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}

	@RequestMapping(value="/api/semester", method=RequestMethod.POST)
	@PostMapping
	(
        value = "/postbody",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<String> createSemester(@RequestBody Semester semester)
	{
		semesterDao.create(semester);
		
		logger.info("Created Semester record: " + semester);
		
	    return new ResponseEntity<>(HttpStatus.CREATED);	
    }

	@RequestMapping(value="/api/semester", method=RequestMethod.PUT)
	@PutMapping
	(
        value = "/putbody",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<String> updateSemester(@RequestBody Semester semester)
	{
		semesterDao.update(semester);
		
		logger.info("Updated Semester record: " + semester);
		
	    return new ResponseEntity<>(HttpStatus.OK);	
    }

	@DeleteMapping("/api/semester/{id}")
    public ResponseEntity<String> deleteSemester(@PathVariable Long id)
	{
		semesterDao.delete(id);
		
		logger.debug("Deleted Semester record: " + id);
	
	    return new ResponseEntity<>(HttpStatus.OK);	
	}
}
