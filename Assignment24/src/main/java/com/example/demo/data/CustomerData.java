package com.example.demo.data;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerData {

    private static final String URL = "jdbc:postgresql://localhost:5432/NetBankingDB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "tiger";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    public Customer getCustomerByID(int custID) {
        String query = "SELECT * FROM customers WHERE customerID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, custID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	Customer customer = new Customer();
                    customer.setCustomerID(rs.getInt("customerID"));
                    customer.setUserName(rs.getString("userName"));
                    customer.setPassword(rs.getString("password"));
                    System.out.println(customer);
                    return customer;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean findCustomer(int custID) {
        String query = "SELECT COUNT(*) FROM customers WHERE customerID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, custID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addCustomer(int id, String name, String pwd) {
        String query = "INSERT INTO customers (customerID, userName, password) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, pwd);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}