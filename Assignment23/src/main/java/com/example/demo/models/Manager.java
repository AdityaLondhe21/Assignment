package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public final class Manager extends Employee {
	
	private Manager() {
		this.setSalary(100000);
		this.setDesignation("MANAGER");
	}
	
	private Manager(String name,int age,int ID) {
		super(name,"MANAGER",100000,age,ID);
	}
	
	private Manager(int ID) {
		super(ID,"MANAGER",100000);
	}
	public static Manager getManager(int ID) {
		return new Manager(ID);
	}
	
	private Manager(String name,String designation,int salary,int age,int empID) {
		super(name,designation,salary,age,empID);
	}
	public static Manager loadManager(String name,String designation,int salary,int age,int empID) {
		return new Manager(name,designation,salary,age,empID);
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary()+15000);
	}

}

