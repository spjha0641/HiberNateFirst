package com.lti.main;

import java.util.Iterator;
import java.util.List;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		/*
		 * Customer c=new Customer(); c.setName("Satya"); c.setEmail("satya@gamil.com");
		 * c.setCity("Navi Mumabi");
		 * 
		 * CustomerDao dao=new CustomerDao(); dao.store(c);
		 */
		
		
		/*
		 * CustomerDao dao=new CustomerDao(); Customer c= dao.fetch(22);
		 * System.out.println(c.getName()); System.out.println(c.getEmail());
		 * System.out.println(c.getCity());
		 */
		
		
		/*
		 * CustomerDao dao=new CustomerDao(); List<Customer> list = dao.fetchAll();
		 * 
		 * for(Customer c: list) { System.out.println(c.getName());
		 * System.out.println(c.getEmail()); System.out.println(c.getCity());
		 * System.out.println("\n==================="); }
		 */
		
		CustomerDao dao=new CustomerDao();
		Customer c=dao.fetch(26);
	//	c.setCity("Delhi");
		dao.delete(c);
		
	//	 System.out.println(c.getName()); System.out.println(c.getEmail());
	//	  System.out.println(c.getCity());
	}

}
