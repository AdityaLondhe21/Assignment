package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "classteacher")
public class ClassTeacher {
	@Id
	private int teacherid;
	private int standard;
	private String name;
	
	@OneToMany(mappedBy = "classTeacher", cascade = CascadeType.ALL)
    private List<Student> students;
	
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ClassTeacher() {
	}
	public ClassTeacher(int standard, String name) {
		this.standard = standard;
		this.name = name;
	}
}
