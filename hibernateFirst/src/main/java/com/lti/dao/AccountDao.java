package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class AccountDao {
	
	public boolean addAnAccount(Account acc) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.persist(acc);
		
		tx.commit();
		em.close();
		emf.close();
		
		return true;
	}
	
	public void addTransactionsIntoAnAccount(List<Transaction> txn, int account) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		
		Account acc=em.find(Account.class, account);
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		for(Transaction t: txn) {
			t.setAccount(acc);
			em.persist(t);

		}
		
		tx.commit();
		em.close();
		emf.close();
		
	}
	
	public Account fetchAccount(int accno) {                                        
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
    	EntityManager em=emf.createEntityManager();                                   
    	                                                                              
    	Account acc=em.find(Account.class, accno);                                                                                                     
                                                            
    	em.close();                                                                   
    	emf.close();                                                                  
    	                                                                              
    	return acc;                                                                  
    } 
	
	public double withdrawFromAccount(Account acc, double amount) {                                        
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
    	EntityManager em=emf.createEntityManager();                                   
    	                                                                              
    	EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		double bal=acc.getAccBal();
		acc.setAccBal(bal-amount);
		em.merge(acc);                                                                                            
                                                            
    	em.close();                                                                   
    	emf.close();                                                                  
    	                                                                              
    	return acc.getAccBal();                                                                  
    } 
	
	
	public void save(Object obj) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		
		  em.merge(obj); 
	
		tx.commit();
		em.close();
		emf.close();

	}
	
	
}