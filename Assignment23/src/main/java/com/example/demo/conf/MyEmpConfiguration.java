package com.example.demo.conf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.models.Address;
import com.example.demo.models.CEO;
import com.example.demo.models.Clerk;
import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeDetails;
import com.example.demo.models.EmployeeList;
import com.example.demo.models.Manager;
import com.example.demo.models.Menu;
import com.example.demo.models.OtherDesignation;
import com.example.demo.models.Programmer;


@Configuration
public class MyEmpConfiguration {
	
	@Bean("get_ceo")
	public CEO getCEO() {
		CEO ceo = CEO.getCEO();
		return ceo;
	}
	
	
	@Bean("get_employee")
	@Scope("prototype")
	public Employee getEmployee() {
		int subChoice=0;
		Menu.createEmployeeMenu(); 
		subChoice = Menu.readChoice(5);  
		
    	if (subChoice == 5) { 
            return null;                    
    	}
    	int empID = EmployeeDetails.readCheckID(100);   
    	
    	Employee employee = switch(subChoice) {
    		case 1-> Clerk.getClerk(empID);
    		case 2-> Programmer.getProgrammer(empID);
    		case 3-> Manager.getManager(empID);
    		default-> OtherDesignation.getOther(empID);
    	};            
    	
        Menu.employeeAddressMenu();
        int addrChoice = Menu.readChoice(3);   
        
        employee.setAddress(getAddress(addrChoice));
                   
    	return employee;
	}
	
	@Bean("addr")
	@Scope("prototype")
	public Address getAddress(int location) {
		return switch(location) {
			case 1->new Address("Maharashtra","Pune",411043);
			case 2->new Address("Maharashtra","Mumbai",410052);
			case 3->new Address("Karnataka","Bangalore",532345);
			default -> new Address("Maharashtra","Pune",411043);
		};
	}
	
}
