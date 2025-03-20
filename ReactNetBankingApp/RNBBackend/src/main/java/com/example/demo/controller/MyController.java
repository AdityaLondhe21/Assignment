package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Transactions;
import com.example.demo.services.CustomerService;
import com.example.demo.services.TransactionsService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MyController {
	@Autowired
	CustomerService customerService;
	@Autowired
	TransactionsService transactionsService;
	
	@RequestMapping(path="/customer",method= {RequestMethod.POST,RequestMethod.PUT})
	public String addCustomer(@RequestBody Customer c) {
		return customerService.addCustomer(c);
	}
	
	@PatchMapping(path="/customer/balance")
	public String updateBalance(@RequestBody Customer c) {
		return customerService.updateBalance(c);
	}
	
	@GetMapping(path="/customer")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping(path="/customer/{id}")
	public Optional<Customer> getCustomerByID(@PathVariable String id){
		return customerService.getCustomerByID(id);
	}
	
	@RequestMapping(path="/transactions", method= {RequestMethod.POST,RequestMethod.PUT})
	public String AddTransaction(@RequestBody Transactions t) {
		return transactionsService.addTransaction(t);
	}
	
	@GetMapping(path="/transactions")
	public List<Transactions> getAllTransactions(){
		return transactionsService.getAllTransactions();
	}
	
	@GetMapping(path="transactions/{id}")
	public List<Transactions> getTransactionsOfCustomer(@PathVariable String id) {
		return transactionsService.getTransactionsOfCustomer(id);
	}
	
}
