package com.softwarehammer.blockone.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.softwarehammer.blockone.entity.Course;

@Mapper
public interface CourseMapper
{
	@Select("select id, code, credits from techtest.course where id = #{id}")
	public Course getCourseById(long id);

	@Insert("insert into techtest.course ("
			+ "id, code, credits) "
			+ "values"
			+ "(#{id}, #{code}, #{credits})")
	public void createCourse(Course course);
	
	@Update("update techtest.course "
			+ "set code=#{code}, credits=#{credits} "
			+ "where id=#{id}")
	public void updateCourse(Course course);
	
	@Delete("delete from techtest.course where id = #{id}")
	public void deleteCourse(long id);

}
