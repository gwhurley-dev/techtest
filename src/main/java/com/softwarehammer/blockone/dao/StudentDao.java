package com.softwarehammer.blockone.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.softwarehammer.blockone.entity.Student;

@Component
public class StudentDao
{
	private final SqlSession sqlSession;

	public StudentDao(SqlSession sqlSession)
	{
		this.sqlSession = sqlSession;
	}
	
	public Student getById(long id) {
	    return this.sqlSession.selectOne("getStudentById", id);
	}

	public void create(Student student)
	{
	    this.sqlSession.insert("createStudent", student);
	}

	public void update(Student student)
	{
	    this.sqlSession.update("updateStudent", student);
	}

	public void delete(long id)
	{
	    this.sqlSession.delete("deleteStudent", id);
	}
}
