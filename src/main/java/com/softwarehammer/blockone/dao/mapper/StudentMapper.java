package com.softwarehammer.blockone.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.softwarehammer.blockone.entity.Student;

@Mapper
public interface StudentMapper
{
	@Select("select id, firstName, lastName, nationality from techtest.student where id = #{id}")
	public Student getStudentById(long id);

	@Insert("insert into techtest.student ("
			+ "id, firstName, lastName, nationality) "
			+ "values"
			+ "(#{id}, #{firstName}, #{lastName}, #{nationality})")
	public void createStudent(Student student);
	
	@Update("update techtest.student "
			+ "set firstName=#{firstName}, lastName=#{lastName}, nationality=#{nationality} "
			+ "where id=#{id}")
	public void updateStudent(Student student);

	@Delete("delete from techtest.student where id = #{id}")
	public void deleteStudent(long id);
}
