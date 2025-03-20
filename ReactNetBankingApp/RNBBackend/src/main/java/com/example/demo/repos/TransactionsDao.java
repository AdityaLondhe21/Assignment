package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Transactions;

public interface TransactionsDao extends JpaRepository<Transactions, String> {
	
	@Query("FROM Transactions WHERE sender_id=?1 OR receiver_id=?2")
	List<Transactions> findBySenderIdOrReceiverId(String id, String id2);

}
