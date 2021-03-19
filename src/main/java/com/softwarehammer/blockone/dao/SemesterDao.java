package com.softwarehammer.blockone.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.softwarehammer.blockone.entity.Semester;

@Component
public class SemesterDao
{
	private final SqlSession sqlSession;

	public SemesterDao(SqlSession sqlSession)
	{
		this.sqlSession = sqlSession;
	}
	
	public Semester getById(long id) {
	    return this.sqlSession.selectOne("getSemesterById", id);
	}

	public void create(Semester semester)
	{
	    this.sqlSession.insert("createSemester", semester);
	}

	public void update(Semester semester)
	{
	    this.sqlSession.update("updateSemester", semester);
	}

	public void delete(long id)
	{
	    this.sqlSession.delete("deleteSemester", id);
	}

}

