package com.softwarehammer.blockone.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.softwarehammer.blockone.entity.Course;
import com.softwarehammer.blockone.entity.Enrollment;

@Component
public class EnrollmentDao
{
	private final SqlSession sqlSession;

	public EnrollmentDao(SqlSession sqlSession)
	{
		this.sqlSession = sqlSession;
	}
	
	public int getCredits(Enrollment enrollment)
	{
		return this.sqlSession.selectOne("getCredits", enrollment);
	}
	
	public void create(Enrollment enrollment)
	{
	    this.sqlSession.insert("createEnrollment", enrollment);
	}
	
	public List<Course> getEnrolledCourses(long studentId, long semesterId)
	{
		HashMap<String, Long> map = new HashMap<String, Long>();

		map.put("studentId", studentId);
		map.put("semesterId", semesterId);

		return this.sqlSession.selectList("getEnrolledCourses", map);
	}

	public List<Course> getEnrollmentHistory(long studentId)
	{
		return this.sqlSession.selectList("getEnrollmentHistory", studentId);
	}

	public void delete(long id)
	{
	    this.sqlSession.delete("deleteEnrollment", id);
	}

}

