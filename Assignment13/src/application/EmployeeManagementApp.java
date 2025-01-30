package application;

import java.io.*;
import java.sql.*;
import java.util.*;

public class EmployeeManagementApp {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EmployeeDB","postgres","tiger");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				Scanner sc = new Scanner(System.in);
			)
			{	
				int choice=0;
				int createEmpChoice=0;
				int displayEmpChoice=0;
				while(choice!=6) {
					Menu.mainMenu();
					choice = Menu.readChoice(6);
					if(choice==1) {
						while(createEmpChoice!=5) {
							Menu.createEmployeeMenu();
							createEmpChoice = Menu.readChoice(5);
							if(createEmpChoice==5) {
								break;
							}
							String designation = switch(createEmpChoice) {
								case 1->"CLERK";
								case 2->"PROGRAMMER";
								case 3->"MANAGER";
								case 4->"OTHER";
								default ->"OTHER";
							};
							PreparedStatement pstmt = con.prepareStatement("insert into Employee(NAME,AGE,SALARY,DESIGNATION) values(?,?,?,?)");
							System.out.println("Enter Name :");
							String name = br.readLine();
							System.out.println("Enter age (between 21 to 60) :");
							int age = Integer.parseInt(br.readLine());
							System.out.println("Enter Salary :");
							int salary = Integer.parseInt(br.readLine());
							pstmt.setString(1,name);
							pstmt.setInt(2,age);
							pstmt.setInt(3, salary);
							pstmt.setString(4, designation);
							pstmt.execute();
							pstmt.close();
						}
					}
					else if(choice==2) {
						while(displayEmpChoice!=6) {
							Menu.displayEmployeeMenu();
							displayEmpChoice = Menu.readChoice(6);
							if(displayEmpChoice==6) {
								break;
							}
							String orderBy = switch (displayEmpChoice) {
			                    case 1 -> "EID";
			                    case 2 -> "NAME";
			                    case 3 -> "AGE";
			                    case 4 -> "SALARY";
			                    case 5 -> "DESIGNATION";
			                    default -> "EID";
							};
							PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee ORDER BY "+orderBy);
							ResultSet rs = pstmt.executeQuery();
							while(rs.next()) {
								System.out.print("ID: " + rs.getInt("EID"));
		                        System.out.print("\tName: " + rs.getString("NAME"));
		                        System.out.print("\tAge: " + rs.getInt("AGE"));
		                        System.out.print("\tSalary: " + rs.getDouble("SALARY"));
		                        System.out.print("\tDesignation: " + rs.getString("DESIGNATION"));
		                        System.out.println("\tDepartment: " + rs.getString("DEPARTMENT"));
		                        System.out.println("-----------------------------------------------------------------");
							}
							rs.close();
							pstmt.close();
						}
					}
					else if(choice==3) {
						System.out.print("Enter EID to raise Salary:");
						String eid = br.readLine();
						PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee WHERE EID="+eid);
						ResultSet rs = pstmt.executeQuery();
						boolean empPresent=false;
						while(rs.next()) {
							empPresent=true;
							System.out.print("ID: " + rs.getInt("EID"));
	                        System.out.print("\tName: " + rs.getString("NAME"));
	                        System.out.print("\tAge: " + rs.getInt("AGE"));
	                        System.out.print("\tSalary: " + rs.getDouble("SALARY"));
	                        System.out.print("\tDesignation: " + rs.getString("DESIGNATION"));
	                        System.out.println("\tDepartment: " + rs.getString("DEPARTMENT"));
	                        System.out.println("-----------------------------------------------------------------");

						}
						
						if(!empPresent) {
							System.out.println("Employee not found");
							continue;
						}
						System.out.print("Enter the Amount: ");
						int amount = Integer.parseInt(br.readLine());
						pstmt = con.prepareStatement("UPDATE Employee SET SALARY = SALARY + ? WHERE EID = ?");
			            pstmt.setInt(1, amount);
			            pstmt.setInt(2, Integer.parseInt(eid));
			            pstmt.executeUpdate();
			            
			            System.out.println("Salary updated");
			            pstmt = con.prepareStatement("SELECT * FROM Employee WHERE EID="+eid);
						rs = pstmt.executeQuery();
						while(rs.next()) {
							System.out.print("ID: " + rs.getInt("EID"));
	                        System.out.print("\tName: " + rs.getString("NAME"));
	                        System.out.print("\tAge: " + rs.getInt("AGE"));
	                        System.out.print("\tSalary: " + rs.getDouble("SALARY"));
	                        System.out.print("\tDesignation: " + rs.getString("DESIGNATION"));
	                        System.out.println("\tDepartment: " + rs.getString("DEPARTMENT"));
	                        System.out.println("-----------------------------------------------------------------");

						}
			            pstmt.close();
					}
					else if(choice==4) {
						System.out.print("Enter EID to Search:");
						String eid = br.readLine();
						PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee WHERE EID="+eid);
						ResultSet rs = pstmt.executeQuery();
						boolean empPresent=false;
						while(rs.next()) {
							empPresent=true;
							System.out.print("ID: " + rs.getInt("EID"));
	                        System.out.print("\tName: " + rs.getString("NAME"));
	                        System.out.print("\tAge: " + rs.getInt("AGE"));
	                        System.out.print("\tSalary: " + rs.getDouble("SALARY"));
	                        System.out.print("\tDesignation: " + rs.getString("DESIGNATION"));
	                        System.out.println("\tDepartment: " + rs.getString("DEPARTMENT"));
	                        System.out.println("-----------------------------------------------------------------");
						}
						if(!empPresent) {
							System.out.println("Employee not found");
							continue;
						}
						rs.close();
						pstmt.close();
					}
					else if(choice==5) {
						System.out.print("Enter EID to Delete:");
						String eid = br.readLine();
						PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee WHERE EID="+eid);
						ResultSet rs = pstmt.executeQuery();
						boolean empPresent=false;
						while(rs.next()) {
							empPresent=true;
							System.out.print("ID: " + rs.getInt("EID"));
	                        System.out.print("\tName: " + rs.getString("NAME"));
	                        System.out.print("\tAge: " + rs.getInt("AGE"));
	                        System.out.print("\tSalary: " + rs.getDouble("SALARY"));
	                        System.out.print("\tDesignation: " + rs.getString("DESIGNATION"));
	                        System.out.println("\tDepartment: " + rs.getString("DEPARTMENT"));
	                        System.out.println("-----------------------------------------------------------------");
						}
						if(!empPresent) {
							System.out.println("Employee not found");
							continue;
						}
			            System.out.println("Employee Deleted");
						pstmt = con.prepareStatement("DELETE FROM Employee WHERE EID = ?");
			            pstmt.setInt(1, Integer.parseInt(eid));
			            pstmt.executeUpdate();
			            rs.close();
			            pstmt.close();
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}


	}

}
