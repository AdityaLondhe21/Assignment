package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.ClassTeacher;

public interface ClassTeacherDao extends JpaRepository<ClassTeacher, Integer>{
	
	@Query("FROM ClassTeacher WHERE standard=?1")
	public ClassTeacher getTeacherByStandard(int standard);
}
