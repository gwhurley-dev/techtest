package com.softwarehammer.blockone;


import java.net.URI;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.softwarehammer.blockone.dao.mapper.CourseMapper;
import com.softwarehammer.blockone.entity.Course;
import com.softwarehammer.blockone.entity.Student;

@Controller
@EnableAutoConfiguration
public class StudentController
{
	
    private final CourseMapper courseMapper;

    public StudentController(CourseMapper courseMapper)
    {
    	this.courseMapper = courseMapper;
    }
    
	@RequestMapping("/api/student")
	@PostMapping
	(
        value = "/postbody",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Student> postBody(@RequestBody Student student) {
		
		Course course = courseMapper.findById(1);
		
        Student persistedStudent = new Student();//personService.save(person);
        persistedStudent.setFirstName(course.getCode());//"yep.");
        return ResponseEntity
            .created(URI
            .create(String.format("/persons/%s", student.getFirstName())))
            .body(persistedStudent);
    }
}
