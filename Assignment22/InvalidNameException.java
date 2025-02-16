
public class InvalidNameException extends Exception{
	public InvalidNameException() {
	}
	public InvalidNameException(String msg) {
		super(msg);
	}
	public void displayMessage() {
		System.out.println("Invalid Name, Possible Reasons:"+
							"\n1. Name/Surname is missing"+
							"\n2. Contains Numeric or Special Characters"+
							"\n3. Starting letters are not capital"+
							"\n4. Either Name or Surname Contains only single character");
	}

}
