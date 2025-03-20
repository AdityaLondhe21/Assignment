package com.example.demo.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Transactions;
import com.example.demo.repos.TransactionsDao;

@Service
public class TransactionsService {
	
	@Autowired
	TransactionsDao dao;
	
	public String addTransaction(Transactions t) {
	    if (dao.existsById(t.getTran_id())) {
	        return "Transaction with this ID already exists";
	    }
	    dao.save(t);
	    return "Transaction added successfully";
	}
	
	public List<Transactions> getTransactionsOfCustomer(String id) {
	    List<Transactions> transactions = dao.findBySenderIdOrReceiverId(id, id);
	    if (transactions.isEmpty()) {
	        return Collections.emptyList();
	    }
	    return transactions;
	}

	public List<Transactions> getAllTransactions() {
		return dao.findAll();
	}
}
