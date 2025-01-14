package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagementApp {
    
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
    
    public static void main(String[] args) {
        // Default Salaries C = 20000 , P = 30000 , M = 100000
        
        Scanner scanner = new Scanner(System.in);
        
        Employee[] employees = new Employee[100];

        int choice=0;
        int subChoice=0;
        
        do {
            mainMenu();
            choice = Menu.readChoice(5);                  
            if (choice == 5)
            {
                break;
            } 
            else if (choice == 1)
            {
                do {    
        			createEmployeeMenu();        			
        			subChoice = Menu.readChoice(4);        			
                	if (subChoice == 4) { 
                        break;                    
                	}
                	int empID = Menu.readCheckID(100, employees);                                        
                    if (subChoice == 1) {
                        // Create Clerk
                        employees[Employee.count] = new Clerk(empID);
                    } 
                    else if (subChoice == 2) {
                        // Create Programmer
                        employees[Employee.count] = new Programmer(empID);
                    }
                    else {
                        // Create Manager
                        employees[Employee.count] = new Manager(empID);
                    }
                    System.out.println("---------------------");
                    employees[Employee.count-1].display();
                } while (subChoice != 4);  
            } 
            
            else if (choice == 2)
            {
            	// Display Employee Details
                System.out.println("------Employees------");
                for (int i = 0; i < Employee.count; i++) {
                    employees[i].display();
                }
            } 
            
            else if (choice == 3)
            {
            	// Raise Salary
                System.out.println("------Salary Raised------");
                for (int i = 0; i < Employee.count; i++) {
                    employees[i].raiseSalary();
                    employees[i].display();
                }
            }
            
            else if (choice == 4)
            {
                // Delete Employee
            	int empID = Menu.readID(100);
            	
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
                    continue;
                }
                System.out.print("Do you want to delete this employee? (y/n): ");
                String ch = scanner.next();
                if (ch.equals("y")) {
                    for (int i = index; i < Employee.count - 1; i++) {
                        employees[i] = employees[i + 1];
                    }
                    employees[Employee.count - 1] = null;
                    Employee.deleteEmployee();
                    System.out.println("------Employee Deleted------");
                }
            } 
        } while (choice != 5);
        
        System.out.println("Total Number Of Employees: " + Employee.count);
        scanner.close();
    }
}