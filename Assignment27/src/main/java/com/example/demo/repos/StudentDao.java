package com.example.demo.repos;

import java.awt.print.Pageable;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
		
	@Query("FROM Student WHERE rollno=?1")
	public Student getStudentsByRollNo(int rollno);	
	
	@Query("FROM Student WHERE school=?1")
	public List<Student> getStudentsBySchool(String school);
	
	@Query("FROM Student WHERE percentage>=40")
	public List<Student> getPassedStudents();
	
	@Query("FROM Student WHERE percentage<40")
	public List<Student> getFailedStudents();
	
	@Query("SELECT COUNT(s) FROM Student s WHERE standard=?1")
	public int getStrengthByStandard(int standard);
	
	@Query("SELECT COUNT(s) FROM Student s WHERE school=?1")
	public int getStrengthOfSchool(String school);

	@Query(value = "SELECT * FROM Student ORDER BY percentage DESC LIMIT 5", nativeQuery = true)
	public List<Student> getToppers();

	@Query(value = "SELECT * FROM Student WHERE standard = ?1 ORDER BY percentage DESC LIMIT 1", nativeQuery = true)
	public Student getTopperByStandard(int standard);

	@Query(value= "SELECT standard FROM Student WHERE regno=?1 LIMIT 1",nativeQuery = true)
	public int getStandardByUnivRegNo(int regNo);
}
