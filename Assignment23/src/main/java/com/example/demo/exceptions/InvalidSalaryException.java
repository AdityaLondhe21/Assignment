package com.example.demo.exceptions;

public class InvalidSalaryException extends Exception{

	public InvalidSalaryException() {
	}
	public InvalidSalaryException(String msg) {
		super(msg);
	}
	public void displayMessage(int minSalary,int maxSalary) {
		System.out.println("Salary Should be in Between "+minSalary+" and "+maxSalary);
	}

}
