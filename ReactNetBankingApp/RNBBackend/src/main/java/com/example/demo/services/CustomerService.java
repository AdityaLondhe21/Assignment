package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repos.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	public String addCustomer(Customer c) {
		if(dao.existsById(c.getId())) {
			return "Customer with this ID  Exists already";
		}
		dao.save(c);
		return "Customer Data Added";
	}
	
	public String updateBalance(Customer c) {
		Optional<Customer> optionalCustomer = dao.findById(c.getId());
	    if (optionalCustomer.isPresent()) {
	        Customer nc = optionalCustomer.get();
	        nc.setBalance(c.getBalance());
	        dao.save(nc);
	        return "Customer balance updated successfully";
	    } else {
	        return "Customer with this ID doesn't exist";
	    }
	}
	
	public List<Customer> getAllCustomers(){
		return dao.findAll();
	}
	public Optional<Customer> getCustomerByID(String id) {
		return dao.findById(id);
	}
}
