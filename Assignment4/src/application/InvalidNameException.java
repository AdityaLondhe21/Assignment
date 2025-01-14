package application;

public class InvalidNameException extends Exception{

	public InvalidNameException() {
	}
	public InvalidNameException(String msg) {
		super(msg);
	}
	public void displayMessage() {
		System.out.println("Invalid Name."+
							"\nReasons:"+
							"\nName/Surname is missing"+
							"\nContains Numeric or Special Characters"+
							"\nStarting letters are not capital");
	}

}
