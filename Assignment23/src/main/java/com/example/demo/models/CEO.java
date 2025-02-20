package com.example.demo.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CEO extends Employee{
	
	private static CEO ceo = null;

	private CEO() {
		super();
	}
	private CEO(String name,int age,int ID) {
		super(name,"CEO",500000,age,ID);
	}
	private CEO(String name,String designation,int salary,int age,int empID) {
		super(name,designation,salary,age,empID);
	}
	private CEO(int ID) {
		super(ID,"CEO",500000);
	}
	
	public static CEO loadCEO(String name,String designation,int salary,int age,int empID) {
		ceo = new CEO(name,designation,salary,age,empID);
		return ceo;
	}
	public static CEO getCEO() {
		if(ceo==null) {
			int ID = EmployeeDetails.readID(100);
			ceo = new CEO(ID);
		}
		return ceo;
	}
	public static void setCEO(Employee c) {
		ceo = (CEO) c;
	}
	
	public static boolean isCEOCreated() {
		if(ceo==null) {
			return false;
		}
		return true;
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary());
	}

}
