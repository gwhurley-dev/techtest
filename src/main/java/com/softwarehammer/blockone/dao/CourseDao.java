package com.softwarehammer.blockone.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.softwarehammer.blockone.entity.Course;

@Component
public class CourseDao
{
	private final SqlSession sqlSession;

	public CourseDao(SqlSession sqlSession)
	{
		this.sqlSession = sqlSession;
	}
	
	public Course getById(long id) {
	    return this.sqlSession.selectOne("getCourseById", id);
	}

	public void create(Course course)
	{
	    this.sqlSession.insert("createCourse", course);
	}

	public void update(Course course)
	{
	    this.sqlSession.update("updateCourse", course);
	}

	public void delete(long id)
	{
	    this.sqlSession.delete("deleteCourse", id);
	}

}

