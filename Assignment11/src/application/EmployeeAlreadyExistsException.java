package application;

public class EmployeeAlreadyExistsException extends Exception {

	EmployeeAlreadyExistsException(){
		super();
	}
	EmployeeAlreadyExistsException(String msg){
		super(msg);
	}
	public void displayMessage() {
		System.out.println("Employee Already Exists.");
	}
}
