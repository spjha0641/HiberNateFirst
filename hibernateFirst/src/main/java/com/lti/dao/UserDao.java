package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Address;
import com.lti.entity.User;

public class UserDao {
	
	
public void addAddress(Address a) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		
		  em.persist(a); 	
		
		tx.commit();
		em.close();
		emf.close();
		
	}
	
	public void addUserWithAddress(User u, int addrId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		Address a=em.find(Address.class, addrId);
		
		EntityTransaction tx= em.getTransaction();
		u.setAddress(a);
		tx.begin();
		
		em.persist(u); 	
		
		tx.commit();
		em.close();
		emf.close();
	}

}
