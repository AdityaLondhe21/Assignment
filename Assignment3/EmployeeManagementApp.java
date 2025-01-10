package emp.assignment;

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
        
        Employee employees[] = new Employee[50];

        int choice;
        int subChoice;
        
        do {
            
            mainMenu();
            
            System.out.println("Choice : ");
            choice = scanner.nextInt();
            if(choice==5) {
            	break;
            }
            else if(choice==1) {
                do {
                    
                    createEmployeeMenu();
                    
                    System.out.println("Choice : ");
                    subChoice = scanner.nextInt();
                    
                    if(subChoice==4) 
                        break;
                    else if(subChoice<=0 || subChoice>4){
                        System.out.println("Enter Valid Input");
                        continue;    
                    }
                    System.out.println("Enter Employee ID :");
                    int empID = scanner.nextInt();
                    
                    boolean empExists = false;
                    for(int i = 0; i < Employee.count; i++){
                        if(employees[i].getID() == empID){
                            empExists = true;
                            break;
                        }
                    }
                    if(empExists){
                        System.out.println("Employee ID already exists, Please use another ID.");
                        continue;
                    }
    
                    System.out.println("Enter Name : ");
                    String name = scanner.next();
                    System.out.println("Enter Age : ");        
                    int age = scanner.nextInt();

                    if(subChoice==1) {
                        // Create Clerk
                        employees[Employee.count] = new Clerk(name, age, empID);
                    }
                    else if(subChoice==2) {
                        // Create Programmer
                        employees[Employee.count] = new Programmer(name, age, empID);
                    }
                    else {
                        // Create Manager
                        employees[Employee.count] = new Manager(name, age, empID);
                    }
                }
                while(subChoice != 4);
            }
            else if(choice == 2) {
            	System.out.println("------Employees------");
                for(int i = 0; i < Employee.count; i++) {
                    employees[i].display();
                }
            }
            else if(choice == 3) {
            	System.out.println("------Salary Raised------");
                for(int i = 0; i < Employee.count; i++) {
                    employees[i].raiseSalary();
                    employees[i].display();
                }
            }
            else if(choice == 4) {
                // Delete Employee
                int empID;
                System.out.println("Enter ID:");
                empID = scanner.nextInt();
                
                int index = 0;
                for(; index < Employee.count; index++) {
                    if(employees[index].getID() == empID) {
                        employees[index].display();
                        break;
                    }
                }
                if(index==Employee.count) {
                	System.out.println("Employee not found.");
                	continue;
                }
                System.out.println("Do you want to delete this employee? (y/n)");
                String ch = scanner.next();
                if(ch.equals("y")) {
                    for(int i = index; i < Employee.count - 1; i++) {
                        employees[i] = employees[i + 1];
                    }
                    employees[Employee.count - 1] = null;
                    Employee.deleteEmployee();
                }
            	System.out.println("------Employee Deleted------");
            }
            else {
                System.out.println("Enter Valid Choice.");
            }
        }
        while(choice != 5);
        
        System.out.println("Total Number Of Employees : " + Employee.count);
    }
}