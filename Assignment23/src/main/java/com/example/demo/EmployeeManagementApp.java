package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.CEO;
import com.example.demo.models.EmployeeList;
import com.example.demo.models.Menu;

@SpringBootApplication
public class EmployeeManagementApp {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmployeeManagementApp.class, args);
    	
        int choice=0;
        if(CEO.isCEOCreated()==false) {
    		System.out.println("CEO Must be Created to proceed further.");
//    		ctx.getBean("ceo");
    		EmployeeList.createCEO();
    	}
        do {
            Menu.mainMenu();
            choice = Menu.readChoice(6); 
            switch(choice) {
            	case 1-> EmployeeList.addEmployee(ctx);
            	case 2-> EmployeeList.displayEmployees();
            	case 3-> EmployeeList.raiseEmployeeSalaries();
            	case 4-> EmployeeList.deleteEmployee();
            	case 5-> EmployeeList.searchEmployee();
            	default-> System.out.println("Total Number Of Employees: " + EmployeeList.getEmployeeCount());
            }
        } while (choice != 6);
        
	}

}
