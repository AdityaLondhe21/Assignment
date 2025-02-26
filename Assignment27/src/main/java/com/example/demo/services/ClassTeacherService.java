package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClassTeacher;
import com.example.demo.repos.ClassTeacherDao;

@Service
public class ClassTeacherService {

	@Autowired
	ClassTeacherDao dao;
	
	public ClassTeacher getClassTeacherByStandard(int standard) {
		return dao.getTeacherByStandard(standard);
	}
	
}
