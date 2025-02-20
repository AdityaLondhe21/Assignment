package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", userName=" + userName + ", password=" + password + "]";
	}

	Integer customerID;
	String userName;
	String password;
	public Customer() {
		
	}
	
	public Customer(Integer id,String name,String pwd) {
		this.customerID=id;
		this.userName=name;
		this.password=pwd;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
