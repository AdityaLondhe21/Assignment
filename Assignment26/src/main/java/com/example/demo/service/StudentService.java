package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repository.db1.StudentRepositoryDB1;
import com.example.demo.repository.db2.StudentRepositoryDB2;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
    private StudentRepositoryDB1 studentRepositoryDb1;

    @Autowired
    private StudentRepositoryDB2 studentRepositoryDb2;

    @Transactional
    public void saveStudent(Student student) {
        studentRepositoryDb1.save(student);
        studentRepositoryDb2.save(student);

    }
}
