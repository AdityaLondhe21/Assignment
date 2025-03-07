package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	
}
