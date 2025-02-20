package com.example.demo.exceptions;

public class InvalidDesignationException extends Exception {

	public InvalidDesignationException() {
	}
	public InvalidDesignationException(String msg) {
		super(msg);
	}
	public void displayMessage() {
		System.out.println("Valid Designations are Clerk, Programmer, Manager, CEO");
	}

}
