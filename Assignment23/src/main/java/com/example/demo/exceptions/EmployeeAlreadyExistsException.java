package com.example.demo.exceptions;

public class EmployeeAlreadyExistsException extends Exception {

	public EmployeeAlreadyExistsException(){
		super();
	}
	EmployeeAlreadyExistsException(String msg){
		super(msg);
	}
	public void displayMessage() {
		System.out.println("Employee Already Exists.");
	}
}
