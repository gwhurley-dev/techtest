package com.softwarehammer.blockone.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.softwarehammer.blockone.entity.Course;

@Mapper
public interface CourseMapper
{
	@Select("select id, code, credits from techtest.course where id = #{id}")
	public Course findById(long id);
}
