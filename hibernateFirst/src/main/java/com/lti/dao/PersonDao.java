package com.lti.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Passport;
import com.lti.entity.Person;

public class PersonDao {
	
	public void addPerson(Person p) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		
		  em.persist(p); 	
		
		tx.commit();
		em.close();
		emf.close();
		
	}
	
	public void addPassportWithPerson(Passport pass, int personId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		Person p=em.find(Person.class, personId);
		
		EntityTransaction tx= em.getTransaction();
		
		pass.setPerson(p);
		
		tx.begin();
		
		em.persist(pass);
		
		tx.commit();
		em.close();
		emf.close();
		
	
	}
}
