
public class InvalidAgeException extends Exception {

	public InvalidAgeException() {
	}
	public InvalidAgeException(String msg) {
		super(msg);
	}
	public void displayMessage(int minAge,int maxAge) {
		System.out.println("Age Should be in Between "+minAge+" and "+maxAge);
	}

}
