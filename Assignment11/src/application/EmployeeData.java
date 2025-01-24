package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class EmployeeData {
	static String fileName = "C:\\Users\\Wissen\\eclipse-workspace\\Assignment11\\src\\application\\Employees.csv";
	
	public static void getData(HashMap<Integer,Employee> employees) {
		String line;
		File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))  {
        	while ((line = br.readLine()) != null) {
                String[] employeeDetails = line.split(",");
                
                int id = Integer.parseInt(employeeDetails[0]);
                String name = employeeDetails[1];
                String designation = employeeDetails[2];
                int age = Integer.parseInt(employeeDetails[3]);
                int salary = Integer.parseInt(employeeDetails[4]);

                switch(designation) {
                	case "CEO" -> employees.put(id, CEO.loadCEO(name, designation, salary, age, id));
                	case "Clerk" -> employees.put(id, Clerk.loadClerk(name, designation, salary, age, id));
                	case "Programmer" -> employees.put(id, Programmer.loadProgrammer(name, designation, salary, age, id));
                	case "Manager" -> employees.put(id, Manager.loadManager(name, designation, salary, age, id));
                	default -> System.out.println("Invalid Designation Found!");
                }
            }
        } catch (Exception e) {
        	System.out.println(e);
        }
	}
	public static void putData(HashMap<Integer, Employee> employees) {
	    File file = new File(fileName);
	    if (!file.exists()) {
	        System.out.println("File does not exist");
	        return;
	    }
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
	        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
	            Employee employee = entry.getValue();
	            bw.write(employee.toString());
	            bw.newLine();
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}
