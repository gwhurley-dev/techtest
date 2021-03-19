package com.softwarehammer.blockone.dao.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.softwarehammer.blockone.entity.Course;
import com.softwarehammer.blockone.entity.Enrollment;

@Mapper
public interface EnrollmentMapper
{
	@Select("select * from course c "
			+ "join enrollment e on e.course_id = c.id "
			+ "join student s on e.student_id = s.id "
			+ "where s.id = #{studentId} "
			+ "and e.semester_id = #{semesterId}")
	public List<Course> getEnrolledCourses(HashMap<String, Long> map);

	@Select("select * from course c "
			+ "join enrollment e on e.course_id = c.id "
			+ "join student s on e.student_id = s.id "
			+ "where s.id = #{studentId}")
	public List<Course> getEnrollmentHistory(long studentId);

	@Select("select sum(c.credits) from student s "
			+ "join enrollment e on s.id = e.student_id "
			+ "join course c on c.id = e.course_id "
			+ "where s.id = #{student.id} "
			+ "and e.semester_id = #{semester.id}")
	public int getCredits(Enrollment enrollment);

	@Insert("insert into techtest.enrollment ("
			+ "id, course_id, semester_id, student_id) "
			+ "values"
			+ "(#{id}, #{course.id}, #{semester.id}, #{student.id})")
	public void createEnrollment(Enrollment enrollment);
	
//	@Update("update techtest.course "
//			+ "set code=#{code}, credits=#{credits} "
//			+ "where id=#{id}")
//	public void updateCourse(Course course);
//	
	@Delete("delete from techtest.enrollment where id = #{id}")
	public void deleteEnrollment(long id);

}
