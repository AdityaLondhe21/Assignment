package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ClassTeacher;
import com.example.demo.entities.Student;
import com.example.demo.services.ClassTeacherService;
import com.example.demo.services.StudentService;


@RestController
public class MyController {
		
	@Autowired
	StudentService studentService;
	
	@Autowired
	ClassTeacherService teacherService;
	
	@RequestMapping(path="/student",method= {RequestMethod.POST,RequestMethod.PUT})
	public String addStudent(@RequestBody Student s) {
		return studentService.addStudent(s);
	}
	
//	/students   - get all students 
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
//	/student/rollno  - get specific student with given roll no 
	@GetMapping("/student/{rollno}")
	public Student getStudentsByRollNo(@PathVariable int rollno) {
		return studentService.getStudentsByRollNo(rollno);
	}
	
//	/students/school?name=DPS    - get all the students of that school 
	@GetMapping("/students/school")
	public List<Student> getStudentsBySchool(@RequestParam("name")String school){
		return studentService.getStudentsBySchool(school);
	}
	
//	/students/result?pass=true/false   - all students above 40% or below 40% 
	@GetMapping("students/result")
	public List<Student> getStudentsByResult(@RequestParam("pass") boolean pass){
		return studentService.getStudentsByResult(pass);
	}
	
//	/students/5/count   - how many students in 5th standard 
	@GetMapping("students/{standard}/count")
	public int getStrengthByStandard(@PathVariable int standard){
		return studentService.getStrengthByStandard(standard);
	}
	
//	/students/strength?school=DPS - total strength for given school 
	@GetMapping("students/strength")
	public int getStrengthOfSchool(@RequestParam String school){
		return studentService.getStrengthOfSchool(school);
	}
	
//	/students/toppers  - top 5 percentage students 
	@GetMapping("students/toppers")
	public List<Student> getToppers(){
		return studentService.getToppers();
	}
	
//	/students/topper/3 - topper of 3rd standard 
	@GetMapping("students/topper/{standard}")
	public Student getTopperByStandard(@PathVariable int standard){
		return studentService.getTopperByStandard(standard);
	}
	
	@GetMapping("/students/class_teacher")
	public ClassTeacher getTeacher(@RequestParam(name = "regNo") int regNo) {
		return teacherService.getClassTeacherByStandard(studentService.getStandardByUnivRegNo(regNo));
	}
	
}
