package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;


@RestController
public class MyController {
	private static 	List<Student> list = new ArrayList<Student>();
	static {
		list.add(new Student(1, "Alice", 10, "DPS", 85.5));
		list.add(new Student(2, "Bob", 9, "KV", 88.0));
		list.add(new Student(3, "Charlie", 8, "DPS", 82.3));
		list.add(new Student(4, "David", 7, "KV", 90.1));
		list.add(new Student(5, "Eva", 6, "DPS", 37.4)); // Failed
		list.add(new Student(6, "Frank", 5, "KV", 83.2));
		list.add(new Student(7, "Grace", 4, "APS", 89.5));
		list.add(new Student(8, "Hannah", 3, "JNV", 91.0));
		list.add(new Student(9, "Ian", 2, "DPS", 84.7));
		list.add(new Student(10, "Jack", 1, "KV", 36.9)); // Failed
		list.add(new Student(11, "Kara", 10, "APS", 88.3));
		list.add(new Student(12, "Leo", 9, "JNV", 85.1));
		list.add(new Student(13, "Mia", 8, "DPS", 87.8));
		list.add(new Student(14, "Nina", 7, "KV", 39.2)); // Failed
		list.add(new Student(15, "Oscar", 6, "APS", 83.9));
		list.add(new Student(16, "Paul", 5, "JNV", 90.4));
		list.add(new Student(17, "Quinn", 4, "DPS", 91.7));
		list.add(new Student(18, "Rita", 3, "KV", 84.5));
		list.add(new Student(19, "Sam", 2, "APS", 86.3));
		list.add(new Student(20, "Tina", 1, "JNV", 38.9)); // Failed
		list.add(new Student(21, "Uma", 10, "DPS", 85.6));
		list.add(new Student(22, "Vince", 9, "KV", 87.1));
		list.add(new Student(23, "Wendy", 8, "APS", 89.8));
		list.add(new Student(24, "Xander", 7, "JNV", 33.4)); // Failed
		list.add(new Student(25, "Yara", 6, "DPS", 90.2));
		list.add(new Student(26, "Zane", 5, "KV", 91.5));
		list.add(new Student(27, "Amy", 4, "APS", 94.1));
		list.add(new Student(28, "Brian", 3, "JNV", 36.7)); // Failed
		list.add(new Student(29, "Cathy", 2, "DPS", 38.5)); // Failed
		list.add(new Student(30, "Derek", 1, "KV", 35.9)); // Failed
	}
	
//	/students   - get all students 
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return list;
	}
	
//	/student/rollNo  - get specific student with given roll no 
	@GetMapping("/student/{rollNo}")
	public Student getStudentsByRollNo(@PathVariable int rollNo) {
		return (Student) list.stream().filter(s->s.getRollNo()==rollNo).findFirst().orElse(null);
	}
	
//	/students/school?name=DPS    - get all the students of that school 
	@GetMapping("/students/school")
	public List<Student> getStudentsBySchool(@RequestParam("name")String school){
		return list.stream().filter(s->s.getSchool().equals(school)).toList();
	}
	
//	/students/result?pass=true/false   - all students above 40% or below 40% 
	@GetMapping("students/result")
	public List<Student> getStudentsByResult(@RequestParam("pass") boolean pass){
		return list.stream().filter(s->pass? s.getPercentage()>=40:s.getPercentage()<40).toList();
	}
	
//	/students/5/count   - how many students in 5th standard 
	@GetMapping("students/{standard}/count")
	public int getStrengthByStandard(@PathVariable int standard){
		return list.stream().filter(s->s.getStandard()==standard).toList().size();
	}
	
//	/students/strength?school=DPS - total strength for given school 
	@GetMapping("students/strength")
	public int getStrengthOfSchool(@RequestParam String school){
		return list.stream().filter(s->s.getSchool().equals(school)).toList().size();
	}
	
//	/students/toppers  - top 5 percentage students 
	@GetMapping("students/toppers")
	public List<Student> getToppers(){
		return list.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(5).toList();
	}
	
//	/students/topper/3 - topper of 3rd standard 
	@GetMapping("students/topper/{standard}")
	public Student getTopperByStandard(@PathVariable int standard){
		return (Student) list.stream()
				.filter(s->s.getStandard()==standard)
				.sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).findFirst().orElse(null);
	}
}
