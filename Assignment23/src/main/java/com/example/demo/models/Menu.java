package com.example.demo.models;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.InvalidChoiceException;


public class Menu {
	public static void mainMenu() {
		System.out.println("----------Main Menu-----------\n"
                + "1. Create.\n"
                + "2. Display.\n"
                + "3. Appraisal.\n"
                + "4. Search.\n"
                + "5. Delete.\n"
                + "6. Exit\n"
                + "---------------------");
    }
    
    public static void createEmployeeMenu() {
        System.out.println("---------Create Employee------------\n"
                + "1. Clerk.\n"
                + "2. Programmer.\n"
                + "3. Manager.\n"
                + "4. Other.\n"
                + "5. Exit.\n"
                + "---------------------------------------");
    }
    public static void employeeAddressMenu() {
        System.out.println("--------- Office Location ------------\n"
                + "1. Pune.\n"
                + "2. Mumbai.\n"
                + "3. Bangalore.\n"
                + "---------------------------------------");
    }
    
    public static void displayEmployeeMenu() {
        System.out.println("---------Display Employees------------\n"
        		+ "Sort on the basis of\n"
                + "1. ID.\n"
                + "2. Name.\n"
                + "3. Age.\n"
                + "4. Salary.\n"
                + "5. Designation\n"
                + "6. Exit\n"
                + "---------------------------------------");
    }
    public static void searchEmployeeMenu() {
        System.out.println("---------Search Employees------------\n"
        		+ "Search on the basis of:\n"
                + "1. ID.\n"
                + "2. Designation.\n"
                + "3. Name.\n"
                + "4. Exit.\n"
                + "---------------------------------------");
    }
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

}

