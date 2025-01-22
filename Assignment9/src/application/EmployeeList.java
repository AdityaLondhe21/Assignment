package application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EmployeeList{
	
	private static HashMap<Integer,Employee> employees = new HashMap<Integer,Employee>();
	
	public static int getEmployeeCount() {
		return employees.size();
	}
	public static boolean checkEmployeeID(int ID) {
		if(employees.containsKey(ID)) {
			return true;
		}
		return false;
	}
	public static Employee getEmployeeByID(int ID) {
		if(employees.containsKey(ID)) {
			return (Employee) employees.get(ID);
		}
		return null;
	}
	public static void createCEO() {
		CEO ceo = CEO.getCEO();
		employees.put(ceo.getID(), ceo);
	}
	public static void addEmployee() {
		int subChoice=0;
    	do {    
			Menu.createEmployeeMenu(); 
			subChoice = Menu.readChoice(4);  
			
        	if (subChoice == 4) { 
                break;                    
        	}
        	int empID = EmployeeDetails.readCheckID(100);                                        
            if (subChoice == 1) {
                // Create Clerk
                employees.put(empID, Clerk.getClerk(empID));
            } 
            else if (subChoice == 2) {
                // Create Programmer
                employees.put(empID,Programmer.getProgrammer(empID));
            }
            else {
                // Create Manager
                employees.put(empID,Manager.getManager(empID));
            }
            System.out.println("----------Employee Created-----------");
            Employee employee =   (Employee) employees.get(empID);
            employee.display();
        } while (subChoice != 4); 
	}
	public static void displayEmployees() {
		System.out.println("------Employees------");
        Set iDset = employees.entrySet();
        Iterator empItr = iDset.iterator();
        while(empItr.hasNext()) {
        	Map.Entry empEntry = (Map.Entry) empItr.next() ;
        	int empID = (int) empEntry.getKey();
        	Employee employee = (Employee) empEntry.getValue();
        	employee.display();
        	System.out.println("---------------------------");
        }
	}
	public static void raiseEmployeeSalaries() {
		System.out.println("------Salary Raised------");
		Set iDset = employees.entrySet();
        Iterator empItr = iDset.iterator();
        while(empItr.hasNext()) {
        	Map.Entry empEntry = (Map.Entry) empItr.next() ;
        	int empID = (int) empEntry.getKey();
        	Employee employee = (Employee) empEntry.getValue();
        	employee.raiseSalary();
        	employee.display();
        	System.out.println("---------------------------");
        }
	}
	public static void deleteEmployee() {
		int empID = EmployeeDetails.readID(100);
    	
		if(!checkEmployeeID(empID)) {
			System.out.println("Employee for this ID doesn't exist.");
			return;
		}
		Employee employee = getEmployeeByID(empID);
		employee.display();
        if(employee.getDesignation()=="CEO") {
        	System.out.println("CEO cannot be deleted.");
        	return;
        }
        
        System.out.print("Do you want to delete this employee? (y/n): ");
        String ch = new Scanner(System.in).next();
        if (ch.equals("y")) {
            employees.remove(empID);
            System.out.println("------Employee Deleted------");
        }
	}
	public static void searchEmployee() {
		int empID = EmployeeDetails.readID(100);
		if(!checkEmployeeID(empID)) {
			System.out.println("Employee for this ID doesn't exist.");
			return;
		}
		Employee employee = getEmployeeByID(empID);
		employee.display();
	}

}
