package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementApp {
	
	public static void mainMenu() {
		System.out.println("---------------------\n"
				+ "1. Create.\n"
				+ "2. Display.\n"
				+ "3. Raise Salary.\n"
				+ "4. Exit.\n"
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
		// TODO Auto-generated method stub
//		Default Salaries C = 20000 , P = 30000 , M = 100000
		
		Scanner scanner = new Scanner(System.in);
		
		List<Programmer> programmers = new ArrayList<Programmer>(); 
		List<Manager> managers = new ArrayList<Manager>(); 
		List<Clerk> clerks = new ArrayList<Clerk>(); 

		while(true) {
			mainMenu();
			System.out.print("Choice : ");
			int choice = Integer.parseInt(scanner.nextLine());
			
			if(choice==1) {
				while(true) {
					createEmployeeMenu();
					System.out.print("Choice : ");
					int subChoice = Integer.parseInt(scanner.nextLine());
					
					if(subChoice==1) {
						System.out.println("Enter Name ,Age : ");
						String name = scanner.nextLine();
						int age = Integer.parseInt(scanner.nextLine());
						
						clerks.add(new Clerk(name,age,20000));
					}
					else if(subChoice==2) {
						System.out.println("Enter Name ,Age : ");
						String name = scanner.nextLine();						
						int age = Integer.parseInt(scanner.nextLine());
						
						programmers.add(new Programmer(name,age,30000));
					}
					else if(subChoice==3) {
						System.out.println("Enter Name ,Age : ");
						String name = scanner.nextLine();						
						int age = Integer.parseInt(scanner.nextLine());
						
						managers.add(new Manager(name,age,100000));
					}
					else if(subChoice==4) {
						break;
					}
					else {
						System.out.println("Enter Valid Input");
					}
				}
				
			}
			else if(choice ==2) {
				System.out.println("-----Programmers-----");
				for (Programmer P:programmers) {
					P.display();
				}
				System.out.println("-----Managers-----");
				for (Manager M:managers) {
					M.display();
				}
				System.out.println("-----Clerks-----");
				for (Clerk C:clerks) {
					C.display();
				}
			}
			else if(choice ==3) {
				for (Programmer P:programmers) {
					P.raiseSalary();
				}
				for (Manager M:managers) {
					M.raiseSalary();
				}
				for (Clerk C:clerks) {
					C.raiseSalary();
				}
				System.out.println("Salary of all employees raised.");
			}
			else if(choice ==4) {
				break;
			}
			else {
				System.out.println("Enter Valid Choice.");
			}
		}
		
		int numberOfProgrammers = programmers.size();
		int numberOfManagers = managers.size();
		int numberOfClerks = clerks.size();
		
		System.out.println("Number Of Programmers : "+ numberOfProgrammers);
		System.out.println("Number Of Managers : "+ numberOfManagers);
		System.out.println("Number Of Clerks : "+ numberOfClerks);
		System.out.println("Total Number Of Employees : "+ (numberOfProgrammers + numberOfManagers + numberOfClerks));

		
		
	}

}
