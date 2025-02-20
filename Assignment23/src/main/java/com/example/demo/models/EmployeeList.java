package com.example.demo.models;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeManagementApp;


@Service
public class EmployeeList{
	
	public static HashMap<Integer,Employee> employees = new HashMap<Integer,Employee>();
	
	public static int getEmployeeCount() {
		return employees.size();
	}
	public static boolean checkEmployeeID(int ID) {
		return employees.containsKey(ID);
	}
	public static Employee getEmployeeByID(int ID) {
		if(employees.containsKey(ID)) {
			return (Employee) employees.get(ID);
		}
		return null;
	}
	
	public static void createCEO() {
		CEO ceo = CEO.getCEO();
		EmployeeList.employees.put(ceo.getID(), ceo);
	}
	
	public static void addEmployee(ApplicationContext ctx) {
		int subChoice=0;
    	do {    
			Employee employee = (Employee)ctx.getBean("get_employee");
			if(employee==null) {
				return;
			}
			EmployeeList.employees.put(employee.getID(), employee);
            System.out.println("----------Employee Created-----------");
            employee.display();
        } while (subChoice != 4); 
	}
	
	public static void displayEmployees() {
		int sortChoice=0;
		do {
			List<Employee> employeeList = new ArrayList<>(EmployeeList.employees.values());
			Menu.displayEmployeeMenu();;
			sortChoice = Menu.readChoice(6);
			
			if(sortChoice==6) {
				break;
			}
	        switch (sortChoice) {
	            case 1 -> employeeList.sort(Comparator.comparingInt(Employee::getID));
	            case 2 -> employeeList.sort(Comparator.comparing(Employee::getName));
	            case 3 -> employeeList.sort(Comparator.comparingInt(Employee::getAge));
	            case 4 -> employeeList.sort(Comparator.comparingInt(Employee::getSalary));
	            case 5 -> employeeList.sort(Comparator.comparing(Employee::getDesignation));
	            default -> System.out.println("Invalid choice. Displaying unsorted list.");
	        }
	        
	        for (Employee employee : employeeList) {
	            employee.display();
	            System.out.println("-------------------------------------------------------------");
	        }
		}while(sortChoice!=6);
	}
	public static void raiseEmployeeSalaries() {
		System.out.println("------Salary Raised------");
		for (Map.Entry<Integer, Employee> empEntry : EmployeeList.employees.entrySet()) {
		    Employee employee = empEntry.getValue();
		    employee.raiseSalary();
		    employee.display();
            System.out.println("-------------------------------------------------------------");
		}
	}
	public static void deleteEmployee() {
		int empID = EmployeeDetails.readID(100);
		if(!EmployeeList.checkEmployeeID(empID)) {
			System.out.println("Employee for this ID doesn't exist.");
			return;
		}
		Employee employee = EmployeeList.getEmployeeByID(empID);
		employee.display();
        if(employee.getDesignation()=="CEO") {
        	System.out.println("CEO cannot be deleted.");
        	return;
        }
        try (Scanner sc = new Scanner(System.in);){
        	System.out.print("Do you want to delete this employee? (y/n): ");
            String ch = sc.next();
            if (ch.equals("y")) {
            	EmployeeList.employees.remove(empID);
                System.out.println("------Employee Deleted------");
            }
		} catch (Exception e) {
			System.out.println(e);
		}        
	}
	public static void searchEmployee() {
		int searchChoice;
		List<Employee> employeeList = new ArrayList<>(EmployeeList.employees.values());

		do {
			List<Employee> matchList = new ArrayList<>();
			Menu.searchEmployeeMenu();
			searchChoice = Menu.readChoice(4);
			if(searchChoice==4) {
				break;
			}else if(searchChoice==1) {
				int empID = EmployeeDetails.readID(100);
				if(EmployeeList.checkEmployeeID(empID)) {
					matchList.add( EmployeeList.getEmployeeByID(empID) );
				}else {
					System.out.println("Employee for this ID doesn't exist.");
				}
			}
			else if(searchChoice==2) {
				String designation = EmployeeDetails.readDesignation();
				for (Employee employee : employeeList) {
		            if (employee.getDesignation().equalsIgnoreCase(designation)) {
		                matchList.add(employee);
		            }
		        }
			}
			else if(searchChoice==3) {
				String name = EmployeeDetails.readName();
				for (Employee employee : employeeList) {
		            if (employee.getName().equalsIgnoreCase(name)) {
		                matchList.add(employee);
		            }
		        }
			}
			System.out.println("-------------Search Results--------------");
			for (Employee employee : matchList) {
	            employee.display();
	            System.out.println("-------------------------------------------------------------");
	        }
		}while(searchChoice!=4);
	}
		
		

}
