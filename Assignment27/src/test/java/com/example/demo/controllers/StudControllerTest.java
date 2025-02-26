//package com.example.demo.controllers;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.example.demo.entities.Student;
//import com.example.demo.services.StudentService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@WebMvcTest(controllers = MyController.class)
//public class StudControllerTest {
//
//	@MockitoBean
//	private StudentService service;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Autowired
//    private ObjectMapper objectMapper;
//
//	@Test
//	public void testAddStudent() {
//		try {
//			Student student = new Student(1, "Alice", 10, "DPS", 85.5);
//	        when(service.addStudent(student)).thenReturn("Student Data Added");
//	        
//	        mockMvc.perform(post("/student")
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .content(objectMapper.writeValueAsString(student)))
//	                .andExpect(status().is(200));
//	        		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetAllStudents() {
//		try {
//			mockMvc.perform(MockMvcRequestBuilders.get("/students"))
//			.andExpect(MockMvcResultMatchers.status().is(200));
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetStudentsByRollNo() {
//		try {
//			Student student = new Student(1, "Alice", 10, "DPS", 85.5);
//	        when(service.getStudentsByRollNo(1)).thenReturn(student);
//			mockMvc.perform(get("/student/1"))
//			.andExpect(status().isOk())
//			.andExpect(content().json(objectMapper.writeValueAsString(student)));
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetStudentsBySchool() {
//		try {
//			List<Student> students = new ArrayList<Student>();
//			students.add(new Student(1, "Alice", 10, "DPS", 85.5));
//	        when(service.getStudentsBySchool("DPS")).thenReturn(students);
//	        
//	        mockMvc.perform(get("/students/school?name=DPS"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().json(objectMapper.writeValueAsString(students)));
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetStudentsByResult() {
//		try {
//			List<Student> passedStudents = new ArrayList<Student>();
//			passedStudents.add(new Student(1, "Alice", 10, "DPS", 85.5));
//	        when(service.getStudentsByResult(true)).thenReturn(passedStudents);
//	        	        
//	        mockMvc.perform(get("/students/result?pass=true"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().json(objectMapper.writeValueAsString(passedStudents)));
//	        
//	        List<Student> failedStudents = new ArrayList<Student>();
//			failedStudents.add(new Student(2, "Bob", 14, "DPS", 35.5));
//	        when(service.getStudentsByResult(false)).thenReturn(failedStudents);
//
//	        mockMvc.perform(get("/students/result?pass=false"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().json(objectMapper.writeValueAsString(failedStudents)));
//	       
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetStrengthByStandard() {
//		try {
//			List<Student> students = new ArrayList<Student>();
//			students.add(new Student(1, "Alice", 10, "DPS", 85.5));
//			students.add(new Student(2, "Aman", 10, "DPS", 55.5));
//			students.add(new Student(3, "Aditya", 10, "DPS", 65.5));
//
//	        when(service.getStrengthByStandard(10)).thenReturn(students.size());
//	        	        
//	        mockMvc.perform(get("/students/10/count"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().json(objectMapper.writeValueAsString(students.size())));
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetStrengthOfSchool() {
//		try {
//			List<Student> students = new ArrayList<Student>();
//			students.add(new Student(1, "Alice", 10, "DPS", 85.5));
//			students.add(new Student(2, "Aman", 10, "DPS", 55.5));
//			students.add(new Student(3, "Aditya", 10, "DPS", 65.5));
//
//	        when(service.getStrengthOfSchool("DPS")).thenReturn(students.size());
//	        	        
//	        mockMvc.perform(get("/students/strength?school=DPS"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().json(objectMapper.writeValueAsString(students.size())));
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testGetToppers() {
//		try {
//			List<Student> students = new ArrayList<Student>();
//			students.add(new Student(1, "Alice", 10, "DPS", 85.5));
//			students.add(new Student(2, "Aman", 10, "DPS", 55.5));
//			students.add(new Student(3, "Aditya", 10, "DPS", 95.5));
//			students.add(new Student(4, "Ankit", 10, "DPS", 75.5));
//			students.add(new Student(5, "Rishi", 10, "DPS", 45.5));
//			students.add(new Student(6, "Mittal", 10, "DPS", 35.5));
//
//	        when(service.getToppers())
//	        .thenReturn(students.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(5).toList());
//	        	        
//	        mockMvc.perform(get("/students/toppers"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().json(objectMapper.writeValueAsString(
//	        		students.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(5).toList())));
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void testGetTopperByStandard() {
//		try {
//			List<Student> students = new ArrayList<Student>();
//			students.add(new Student(1, "Alice", 10, "DPS", 85.5));
//			students.add(new Student(2, "Aman", 8, "DPS", 55.5));
//			students.add(new Student(3, "Aditya", 10, "DPS", 95.5));
//			students.add(new Student(4, "Ankit", 10, "DPS", 75.5));
//			students.add(new Student(5, "Rishi", 9, "DPS", 45.5));
//			students.add(new Student(6, "Mittal", 10, "DPS", 35.5));
//
//	        when(service.getTopperByStandard(10)).thenReturn(students.stream()
//					.filter(s->s.getStandard()==10)
//					.sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).findFirst().orElse(null));
//	        	        
//	        mockMvc.perform(get("/students/topper/10"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().json(objectMapper.writeValueAsString(students.stream()
//					.filter(s->s.getStandard()==10)
//					.sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).findFirst().orElse(null))));
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
