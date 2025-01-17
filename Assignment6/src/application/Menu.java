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
	public static void mainMenu() {
        System.out.println("---------------------\n"
                + "1. Create.\n"
                + "2. Display.\n"
                + "3. Raise Salary.\n"
                + "4. Delete.\n"
                + "5. Exit.\n"
                + "---------------------");
    }
    
    public static void createEmployeeMenu() {
        System.out.println("---------------------\n"
                + "1. Clerk.\n"
                + "2. Programmer.\n"
                + "3. Manager.\n"
                + "4. Exit.\n"
                + "---------------------");
    }
    
    public static void createEmployee(Employee employees[]) {
    	int subChoice=0;
    	do {    
        	
			Menu.createEmployeeMenu(); 
			subChoice = Menu.readChoice(4);  
			
        	if (subChoice == 4) { 
                break;                    
        	}
        	int empID = EmployeeDetails.readCheckID(100, employees);                                        
            if (subChoice == 1) {
                // Create Clerk
                employees[Employee.count] = Clerk.getClerk(empID);
            } 
            else if (subChoice == 2) {
                // Create Programmer
                employees[Employee.count] = Programmer.getProgrammer(empID);
            }
            else {
                // Create Manager
                employees[Employee.count] = Manager.getManager(empID);
            }
            System.out.println("---------------------");
            employees[Employee.count-1].display();
        } while (subChoice != 4);  
    }
    
    public static void displayEmployees(Employee employees[]) {
    	System.out.println("------Employees------");
        for (int i = 0; i < Employee.count; i++) {
            employees[i].display();
        }
    }
    
    public static void raiseEmployeeSalaries(Employee employees[]) {
    	System.out.println("------Salary Raised------");
        for (int i = 0; i < Employee.count; i++) {
            employees[i].raiseSalary();
            employees[i].display();
        }
    }
    
    public static void deleteEmployee(Employee employees[]) {
    	int empID = EmployeeDetails.readID(100);
    	
        int index = -1;
        for (int i = 0; i < Employee.count; i++) {
            if (employees[i].getID() == empID) {
                employees[i].display();
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        if(employees[index].getDesignation()=="CEO") {
        	System.out.println("CEO cannot be deleted.");
        	return;
        }
        System.out.print("Do you want to delete this employee? (y/n): ");
        String ch = new Scanner(System.in).next();
        if (ch.equals("y")) {
            for (int i = index; i < Employee.count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[Employee.count - 1] = null;
            Employee.deleteEmployee();
            System.out.println("------Employee Deleted------");
        }
    }
}

