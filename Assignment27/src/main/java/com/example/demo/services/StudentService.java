package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repos.StudentDao;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	
	public String addStudent(Student s) {
		if(dao.existsById(s.getRollNo())) {
			return "Student with this Roll Number Exists already";
		}
		dao.save(s);
		return "Student Data Added";
	}
	
	public List<Student> getAllStudents(){
		return dao.findAll();
	}

	public Student getStudentsByRollNo(int rollno) {
		return dao.getStudentsByRollNo(rollno);
	}
	
	public List<Student> getStudentsBySchool(String school){
		return dao.getStudentsBySchool(school);
	}

	public List<Student> getStudentsByResult(boolean pass){
		if(pass) {
			return dao.getPassedStudents();
		}
		return dao.getFailedStudents();
	}
	
	public int getStrengthByStandard(int standard){
		return dao.getStrengthByStandard(standard);	
	}

	public int getStrengthOfSchool( String school){
		return dao.getStrengthOfSchool(school);
	}
	

	public List<Student> getToppers(){
		return dao.getToppers();
	}
	
	public Student getTopperByStandard(int standard){
		return dao.getTopperByStandard(standard);
	}
	
	public int getStandardByUnivRegNo(int regNo) {		
		return dao.getStandardByUnivRegNo(regNo);
	}
}
