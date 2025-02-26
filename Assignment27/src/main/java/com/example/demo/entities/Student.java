package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	private int regno;
	private int rollno;
	private String name;
	private int standard;
	private String school;
	private double percentage;
	
	@ManyToOne
    @JoinColumn(name = "standard", referencedColumnName = "standard", insertable = false, updatable = false)
    private ClassTeacher classTeacher;
	
	
	public Student(int regNo, int rollno, String name, int standard, String school, double percentage) {
		super();
		this.regno = regNo;
		this.rollno = rollno;
		this.name = name;
		this.standard = standard;
		this.school = school;
		this.percentage = percentage;
	}
	public Student() {
		super();
	}
	public int getRollNo() {
		return rollno;
	}
	public void setRollNo(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStandard() {
		return standard;
	}
	public int getRegNo() {
		return regno;
	}
	public void setRegNo(int univRegNo) {
		this.regno = univRegNo;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
}
