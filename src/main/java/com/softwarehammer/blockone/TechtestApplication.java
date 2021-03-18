package com.softwarehammer.blockone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softwarehammer.blockone.dao.mapper.CourseMapper;
import com.softwarehammer.blockone.entity.Course;


@SpringBootApplication
public class TechtestApplication implements CommandLineRunner
{
    private final CourseMapper courseMapper;

    public TechtestApplication(CourseMapper courseMapper)
    {
    	this.courseMapper = courseMapper;
    }
    
    @Override
    public void run(String... args) throws Exception {
        Course course = courseMapper.findById(1);
        
        System.out.println(course.getId() + " - " + course.getCode() + " - " + course.getCredits());
    }
    
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(TechtestApplication.class, args);
		System.out.println("Test1.");
	}


}
