package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmployeeDao;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;

	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	public String addEmployee(Employee e) {
		if(dao.existsById(e.getEmpID())) {
			return "Employee with this Roll Number Exists already";
		}
		dao.save(e);
		return "Employee Data Added";
	}
	
	public Optional<Employee> searchEmployeeByID(int id) {
		return dao.findById(id);
	}

	public String updateEmployee(Employee e) {
		if(dao.existsById(e.getEmpID())) {
			dao.save(e);
			return "Employee Data Updated";
		}
		return "Employee Doesn't Exist";
	}

	public String deleteEmployee(int id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
			return "Employee Data Deleted";
		}
		return "Employee Doesn't Exist";
	}
	
	
}
