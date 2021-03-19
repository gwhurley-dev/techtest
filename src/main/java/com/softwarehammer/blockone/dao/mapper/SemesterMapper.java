package com.softwarehammer.blockone.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.softwarehammer.blockone.entity.Semester;

@Mapper
public interface SemesterMapper
{
	@Select("select id, year, semester from techtest.semester where id = #{id}")
	public Semester getSemesterById(long id);

	@Insert("insert into techtest.semester ("
			+ "id, year, semester) "
			+ "values"
			+ "(#{id}, #{year}, #{semester})")
	public void createSemester(Semester semester);
	
	@Update("update techtest.semester "
			+ "set year=#{year}, semester=#{semester} "
			+ "where id=#{id}")
	public void updateSemester(Semester semester);

	@Delete("delete from techtest.semester where id = #{id}")
	public void deleteSemester(long id);

}
