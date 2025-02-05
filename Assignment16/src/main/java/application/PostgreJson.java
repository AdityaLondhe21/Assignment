package application;

import java.sql.*;

import org.json.JSONObject;


public class PostgreJson {
	private static final String url = "jdbc:postgresql://localhost:5432/demoDB";
	private static final String username = "postgres";
	private static final String password = "tiger";
	
	public static void createEmployee(String name,int age) {
		 
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", name);
		jsonData.put("age", age);
		
		String query = "INSERT INTO Employee_data (data) VALUES (?::jsonb)";

		try(Connection con = DriverManager.getConnection(url,username,password);
	             PreparedStatement pst = con.prepareStatement(query)) 
		{
	            pst.setString(1, jsonData.toString());
	            pst.executeUpdate();	
	            
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void displayEmployee() {
        String query = "SELECT * FROM Employee_data";
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
            	int id = rs.getInt("id");
                String data = rs.getString("data");
                JSONObject json = new JSONObject(data);
                System.out.println("ID: " + id);
                System.out.println("Name: " + json.getString("name"));
                System.out.println("Age: " + json.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	public static void deleteEmployee(String name) {
		String query = "DELETE FROM Employee_data WHERE data->>'name' = ?";
	
	    try (Connection con = DriverManager.getConnection(url, username, password);
	         PreparedStatement pst = con.prepareStatement(query)) 
	    {
	    	pst.setString(1, name);
	        pst.executeUpdate();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	public static void updateEmployee(String name, int age, int newAge) {
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", name);
        jsonData.put("age", newAge);

        String query = "UPDATE Employee_data SET data = ?::jsonb WHERE data->>'name' = ?";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, jsonData.toString());
            pst.setString(2, name);
            pst.setInt(3, age);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	public static void main(String[] args) {
//		createEmployee("Mahesh",34);
		displayEmployee();
	}

}
