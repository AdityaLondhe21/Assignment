package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class EmployeeData {
//	static String fileName = "C:\\Users\\Wissen\\eclipse-workspace\\Assignment11\\src\\application\\Employees.csv";
	static String serFileName = "C:\\Users\\Wissen\\eclipse-workspace\\Assignment13\\src\\application\\Employees.ser";
//	public static void getData(HashMap<Integer,Employee> employees) {
//		String line;
//		File file = new File(fileName);
//        if (!file.exists()) {
//            System.out.println("File does not exist");
//            return;
//        }
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))  {
//        	while ((line = br.readLine()) != null) {
//                String[] employeeDetails = line.split(",");
//                
//                int id = Integer.parseInt(employeeDetails[0]);
//                String name = employeeDetails[1];
//                String designation = employeeDetails[2];
//                int age = Integer.parseInt(employeeDetails[3]);
//                int salary = Integer.parseInt(employeeDetails[4]);
//
//                switch(designation) {
//                	case "CEO" -> employees.put(id, CEO.loadCEO(name, designation, salary, age, id));
//                	case "Clerk" -> employees.put(id, Clerk.loadClerk(name, designation, salary, age, id));
//                	case "Programmer" -> employees.put(id, Programmer.loadProgrammer(name, designation, salary, age, id));
//                	case "Manager" -> employees.put(id, Manager.loadManager(name, designation, salary, age, id));
//                	default -> System.out.println("Invalid Designation Found!");
//                }
//            }
//        } catch (Exception e) {
//        	System.out.println(e);
//        }
//	}
//	public static void putData(HashMap<Integer, Employee> employees) {
//	    File file = new File(fileName);
//	    if (!file.exists()) {
//	        System.out.println("File does not exist");
//	        return;
//	    }
//	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
//	        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
//	            Employee employee = entry.getValue();
//	            bw.write(employee.toString());
//	            bw.newLine();
//	        }
//	    } catch (Exception e) {
//	        System.out.println(e);
//	    }
//	}
	
	public static void deserializeData(HashMap<Integer,Employee> employees){
		File file = new File(serFileName);
	    if (!file.exists()) {
	        System.out.println("File does not exist");
	        return;
	    }
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFileName))) {
	        Employee employee;
	        while ((employee = (Employee) ois.readObject()) != null) {
	            if (employee.getDesignation().equals("CEO")) {
	                CEO.setCEO(employee);
	            }
	            employees.put(employee.getID(), employee);
	        }
	    }
	    catch(EOFException e) {
	    }
	    catch (Exception e) {
	        System.out.println(e);
	    }
	}
	public static void serializeData(HashMap<Integer,Employee> employees) {
		File file = new File(serFileName);
	    if (!file.exists()) {
	        System.out.println("File does not exist");
	        return;
	    }
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFileName))) {
	        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
	            Employee employee = entry.getValue();
	            oos.writeObject(employee);
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
}
