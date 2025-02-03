package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.sql.rowset.JdbcRowSet;

public class EmployeeDAO {
	public static void addEmployee() {
        int createEmpChoice = 0;
        while (createEmpChoice != 5) {
            Menu.createEmployeeMenu();
            createEmpChoice = Menu.readChoice(5);
            if (createEmpChoice == 5) {
                break;
            }
            String designation = switch (createEmpChoice) {
                case 1 -> "CLERK";
                case 2 -> "PROGRAMMER";
                case 3 -> "MANAGER";
                case 4 -> "OTHER";
                default -> "OTHER";
            };
            try (JdbcRowSet rowSet = DBConnection.getConnection();
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
            {
                rowSet.setCommand("INSERT INTO Employee(NAME, AGE, SALARY, DESIGNATION) VALUES(?, ?, ?, ?)");
                System.out.println("Enter Name:");
                String name = br.readLine();
                System.out.println("Enter age :");
                int age = Integer.parseInt(br.readLine());
                System.out.println("Enter Salary:");
                int salary = Integer.parseInt(br.readLine());
                rowSet.setString(1, name);
                rowSet.setInt(2, age);
                rowSet.setInt(3, salary);
                rowSet.setString(4, designation);
                rowSet.execute();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void displayEmployee() {
        int displayEmpChoice = 0;
        while (displayEmpChoice != 6) {
            Menu.displayEmployeeMenu();
            displayEmpChoice = Menu.readChoice(6);
            if (displayEmpChoice == 6) {
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
            try (JdbcRowSet rowSet = DBConnection.getConnection()) 
            {
                rowSet.setCommand("SELECT * FROM Employee ORDER BY " + orderBy);
                rowSet.execute();
                while (rowSet.next()) {
                    System.out.print("ID: " + rowSet.getInt("EID"));
                    System.out.print("\tName: " + rowSet.getString("NAME"));
                    System.out.print("\tAge: " + rowSet.getInt("AGE"));
                    System.out.print("\tSalary: " + rowSet.getDouble("SALARY"));
                    System.out.print("\tDesignation: " + rowSet.getString("DESIGNATION"));
                    System.out.println("\tDepartment: " + rowSet.getString("DEPARTMENT"));
                    System.out.println("-----------------------------------------------------------------");
                }
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void raiseSalary() {
        try (JdbcRowSet rowSet = DBConnection.getConnection();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
        {
            System.out.print("Enter EID to raise Salary:");
            String eid = br.readLine();
            rowSet.setCommand("SELECT * FROM Employee WHERE EID=" + eid);
            rowSet.execute();
            boolean empPresent = false;
            while (rowSet.next()) {
                empPresent = true;
                System.out.print("ID: " + rowSet.getInt("EID"));
                System.out.print("\tName: " + rowSet.getString("NAME"));
                System.out.print("\tAge: " + rowSet.getInt("AGE"));
                System.out.print("\tSalary: " + rowSet.getDouble("SALARY"));
                System.out.print("\tDesignation: " + rowSet.getString("DESIGNATION"));
                System.out.println("\tDepartment: " + rowSet.getString("DEPARTMENT"));
                System.out.println("-----------------------------------------------------------------");
            }

            if (!empPresent) {
                System.out.println("Employee not found");
                return;
            }
            System.out.print("Enter the Amount: ");
            int amount = Integer.parseInt(br.readLine());
            rowSet.setCommand("UPDATE Employee SET SALARY = SALARY + ? WHERE EID = ?");
            rowSet.setInt(1, amount);
            rowSet.setInt(2, Integer.parseInt(eid));
            rowSet.execute();

            System.out.println("Salary updated");
            rowSet.setCommand("SELECT * FROM Employee WHERE EID=" + eid);
            rowSet.execute();
            while (rowSet.next()) {
                System.out.print("ID: " + rowSet.getInt("EID"));
                System.out.print("\tName: " + rowSet.getString("NAME"));
                System.out.print("\tAge: " + rowSet.getInt("AGE"));
                System.out.print("\tSalary: " + rowSet.getDouble("SALARY"));
                System.out.print("\tDesignation: " + rowSet.getString("DESIGNATION"));
                System.out.println("\tDepartment: " + rowSet.getString("DEPARTMENT"));
                System.out.println("-----------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void searchEmployee() {    	
        try (JdbcRowSet rowSet = DBConnection.getConnection();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
        {
            System.out.print("Enter EID to Search:");
            String eid = br.readLine();
            rowSet.setCommand("SELECT * FROM Employee WHERE EID=" + eid);
            rowSet.execute();
            boolean empPresent = false;
            while (rowSet.next()) {
                empPresent = true;
                System.out.print("ID: " + rowSet.getInt("EID"));
                System.out.print("\tName: " + rowSet.getString("NAME"));
                System.out.print("\tAge: " + rowSet.getInt("AGE"));
                System.out.print("\tSalary: " + rowSet.getDouble("SALARY"));
                System.out.print("\tDesignation: " + rowSet.getString("DESIGNATION"));
                System.out.println("\tDepartment: " + rowSet.getString("DEPARTMENT"));
                System.out.println("-----------------------------------------------------------------");
            }
            if (!empPresent) {
                System.out.println("Employee not found");
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteEmployee() {
        try (JdbcRowSet rowSet = DBConnection.getConnection();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
        {
            System.out.print("Enter EID to Delete:");
            String eid = br.readLine();
            rowSet.setCommand("SELECT * FROM Employee WHERE EID=" + eid);
            rowSet.execute();
            boolean empPresent = false;
            while (rowSet.next()) {
                empPresent = true;
                System.out.print("ID: " + rowSet.getInt("EID"));
                System.out.print("\tName: " + rowSet.getString("NAME"));
                System.out.print("\tAge: " + rowSet.getInt("AGE"));
                System.out.print("\tSalary: " + rowSet.getDouble("SALARY"));
                System.out.print("\tDesignation: " + rowSet.getString("DESIGNATION"));
                System.out.println("\tDepartment: " + rowSet.getString("DEPARTMENT"));
                System.out.println("-----------------------------------------------------------------");
            }
            if (!empPresent) {
                System.out.println("Employee not found");
                return;
            }
            System.out.println("Employee Deleted");
            rowSet.setCommand("DELETE FROM Employee WHERE EID = ?");
            rowSet.setInt(1, Integer.parseInt(eid));
            rowSet.execute();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
