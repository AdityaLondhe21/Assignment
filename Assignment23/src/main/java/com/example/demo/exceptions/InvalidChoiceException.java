package com.example.demo.exceptions;

public class InvalidChoiceException extends Exception{
	
	public InvalidChoiceException(){
		super();
	}
	InvalidChoiceException(String msg){
		super(msg);
	}
	public void displayMessage(int maxChoice) {
		System.out.println("Choice should be in between 1 and "+maxChoice);
	}
	
}