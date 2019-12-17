package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.Album;
import com.lti.entity.Order;
import com.lti.entity.OrderItem;
import com.lti.entity.Song;

public class GenericDao {
	
	public void add(Object obj) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		
		  em.merge(obj); 
	
		tx.commit();
		em.close();
		emf.close();

	}
	
	public void fetchOrderDetails(int orderId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		Order od=em.find(Order.class, orderId);
		
		List<OrderItem> items=od.getItems();
		
		System.out.println("Item Id   :   Quantity  :    Price    :   OrderDate");
		for(OrderItem item: items) {
			System.out.println(item.getItemId()+" : "+item.getQuantity()+" : "+item.getPrice()+ " : "+od.getOrderDate());
		}
	
	}
	public List<Object> fetchAllSongs() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		//JPQL
		Query q = em.createQuery("select s from Object s");
		List<Object> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}
	
	public Album fetchAlbumByTitle(String albumName) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		Query q = em.createQuery("select a from Album a where a.albumName=:at");
		q.setParameter("at", albumName);
		
		Album album =(Album) q.getSingleResult();
		
		return album;
		
	}
	
	public List<Song> fetchAllSongsFromAnAlbum(String albumName){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		Query q = em.createQuery("select s from Song s where s.album.albumName=:at");
		q.setParameter("at",albumName);
		List<Song> songs = q.getResultList();
		
		return songs;
	}

	public List<Account> fetchAllAccountWithTrans(double amount){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		Query q = em.createQuery("select a from Account a inner join a.transactions tx where tx.amount>:am");
		q.setParameter("am", amount);
		List<Account> accs = q.getResultList();
		
		return accs;
		
	}
	
}
