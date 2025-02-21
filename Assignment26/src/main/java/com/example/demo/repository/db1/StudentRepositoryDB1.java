package com.example.demo.repository.db1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;

public interface StudentRepositoryDB1 extends JpaRepository<Student,Integer> {

}
