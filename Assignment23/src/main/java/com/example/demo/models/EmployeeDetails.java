package com.example.demo.models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.exceptions.EmployeeAlreadyExistsException;
import com.example.demo.exceptions.InvalidAgeException;
import com.example.demo.exceptions.InvalidDesignationException;
import com.example.demo.exceptions.InvalidIDException;
import com.example.demo.exceptions.InvalidNameException;

public class EmployeeDetails {
    private static final List<String> designations = new ArrayList<>(Arrays.asList("CLERK", "MANAGER", "PROGRAMMER", "CEO", "OTHER"));

	static int minAge, maxAge;
	public static int readAge(int min,int max) {
		EmployeeDetails.minAge=min;
		EmployeeDetails.maxAge=max;
		
		int age;
		while(true) {
			System.out.print("Enter Age: ");
			try {
				age = new Scanner(System.in).nextInt();
				if(age<EmployeeDetails.minAge || age>EmployeeDetails.maxAge) {
					throw new InvalidAgeException();
				}
				return age;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidAgeException e) {
				e.displayMessage(EmployeeDetails.minAge, EmployeeDetails.maxAge);
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
	public static int readCheckID(int max) {
		EmployeeDetails.maxID=max;
		int id;
		while(true) {
			System.out.print("Enter Employee ID : ");
			try {
				id = new Scanner(System.in).nextInt();
				if(id<1 || id>EmployeeDetails.maxID) {
					throw new InvalidIDException();
				}
                if (EmployeeList.checkEmployeeID(id)) {
                    throw new EmployeeAlreadyExistsException();
                }
				return id;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidIDException e) {
				e.displayMessage(EmployeeDetails.maxID);
			}
			catch(EmployeeAlreadyExistsException e) {
				e.displayMessage();
			}
		}
	}
	public static int readID(int max) {
		EmployeeDetails.maxID=max;
		int id;
		while(true) {
			System.out.print("Enter Employee ID : ");
			try {
				id = new Scanner(System.in).nextInt();
				if(id<1 || id>EmployeeDetails.maxID) {
					throw new InvalidIDException();
				}
				return id;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidIDException e) {
				e.displayMessage(EmployeeDetails.maxID);
			}
		}
	}
	
	public static String readDesignation() {
		String designation;
		while(true) {
			System.out.print("Enter Designation : ");
			try {
				designation = new Scanner(System.in).nextLine();
				if(!designations.contains(designation)) {
					throw new InvalidDesignationException();
				}
				return designation;
			}
			catch(InvalidDesignationException e) {
				e.displayMessage();
			}
		}
	}

    public static int readSalary(int minSalary, int maxSalary) {
        int salary;
        while (true) {
            System.out.print("Enter Salary: ");
            try {
                salary = new Scanner(System.in).nextInt();
                if (salary < minSalary || salary > maxSalary) {
                    throw new InvalidAgeException();
                }
                return salary;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter Integer only.");
            } catch (InvalidAgeException e) {
                e.displayMessage(minSalary, maxSalary);
            }
        }
    }
}