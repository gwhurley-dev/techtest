package com.softwarehammer.blockone.dao;

import org.apache.ibatis.session.SqlSession;

import com.softwarehammer.blockone.entity.Course;

public class CourseDao
{
	private final SqlSession sqlSession;

	public CourseDao(SqlSession sqlSession)
	{
		this.sqlSession = sqlSession;
	}
	public Course selectCityById(long id) {
	    return this.sqlSession.selectOne("selectCityById", id);
	}
}
