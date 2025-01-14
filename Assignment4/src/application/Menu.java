package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

	static int maxChoice;
	public static int readChoice(int max) {
		Menu.maxChoice=max;
		int choice;
		while(true) {
			System.out.print("Enter Choice : ");
			try {
				choice = new Scanner(System.in).nextInt();
				if(choice<1 || choice>Menu.maxChoice) {
					throw new InvalidChoiceException();
				}
				return choice;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidChoiceException e) {
				e.displayMessage(Menu.maxChoice);
			}
		}
	}
	
	
	static int minAge, maxAge;
	public static int readAge(int min,int max) {
		Menu.minAge=min;
		Menu.maxAge=max;
		
		int age;
		while(true) {
			System.out.print("Enter Age: ");
			try {
				age = new Scanner(System.in).nextInt();
				if(age<Menu.minAge || age>Menu.maxAge) {
					throw new InvalidAgeException();
				}
				return age;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidAgeException e) {
				e.displayMessage(Menu.minAge, Menu.maxAge);
			}
		}
	}
	
	public static String readName() {
		String name;
		String regex = "^[A-Z][a-z]+\\s[A-Z][a-z]+$";
		
		Pattern p = Pattern.compile(regex);
		while(true) {
			System.out.print("Enter Name and Surname : ");
			try {
				name = new Scanner(System.in).nextLine();
				Matcher m = p.matcher(name);
				if(!m.matches()) {
					throw new InvalidNameException();
				}
				return name;
			}
			catch(InvalidNameException e) {
				e.displayMessage();
				
			}
		}
	}
	
	static int maxID;
	public static int readCheckID(int max,Employee employees[]) {
		Menu.maxID=max;
		int id;
		while(true) {
			System.out.print("Enter Employee ID : ");
			try {
				id = new Scanner(System.in).nextInt();
				if(id<1 || id>Menu.maxID) {
					throw new InvalidIDException();
				}
				for (int i = 0; i < Employee.count; i++) {
                    if (employees[i].getID() == id) {
                        throw new EmployeeAlreadyExistsException();
                    }
                }
				return id;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidIDException e) {
				e.displayMessage(Menu.maxID);
			}
			catch(EmployeeAlreadyExistsException e) {
				e.displayMessage();
			}
		}
	}
	public static int readID(int max) {
		Menu.maxID=max;
		int id;
		while(true) {
			System.out.print("Enter Employee ID : ");
			try {
				id = new Scanner(System.in).nextInt();
				if(id<1 || id>Menu.maxID) {
					throw new InvalidIDException();
				}
				return id;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidIDException e) {
				e.displayMessage(Menu.maxID);
			}
		}
	}
	
}

