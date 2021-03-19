package com.softwarehammer.blockone.entity;

import lombok.Data;

@Data
public class Enrollment
{
	private int id;
	private Student student;
	private Course course;
	private Semester semester;
}
