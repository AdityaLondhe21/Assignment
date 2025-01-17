package application;

import java.util.Scanner;

public class EmployeeManagementApp {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Employee[] employees = new Employee[100];
        
        int choice=0;
        int subChoice=0;
        
        do {
        	if(CEO.isCEOCreated()==false) {
        		System.out.println("CEO Must be Created to proceed further.");
        		employees[Employee.count] = CEO.getCEO();
        		employees[Employee.count-1].display();
        	}
        	
            Menu.mainMenu();
            choice = Menu.readChoice(5); 
            
            if (choice == 5)
            {
                break;
            } 
            else if (choice == 1)
            {
            	Menu.createEmployee(employees);
            } 
            
            else if (choice == 2)
            {
            	// Display Employee Details
            	Menu.displayEmployees(employees);
            } 
            
            else if (choice == 3)
            {
            	// Raise Salary
            	Menu.raiseEmployeeSalaries(employees);
            }
            
            else if (choice == 4)
            {
                // Delete Employee
            	Menu.deleteEmployee(employees);
            } 
        } while (choice != 5);
        
        System.out.println("Total Number Of Employees: " + Employee.count);
        scanner.close();
    }
}