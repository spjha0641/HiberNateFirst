package com.lti.main;

import java.time.LocalDate;

import com.lti.dao.PersonDao;
import com.lti.entity.Passport;
import com.lti.entity.Person;

public class PersonPassportMain {
	
	public static void main(String[] args) {
		PersonDao dao=new PersonDao();
		  Person p=new Person();
		  
		  p.setPersonName("Satya");
		  p.setPersonAge(23);
		  
		  dao.addPerson(p);
		  
		  Passport pass=new Passport(); pass.setPassportNo("P1003");
		  pass.setIssueDate(LocalDate.of(2017, 06, 02));
		  pass.setExpiryDate(LocalDate.of(2027, 06, 01));
		  pass.setPlaceOfIssue("Mumbai");
		  
		  int personId=p.getPersonId();
		
		dao.addPassportWithPerson(pass, personId);
		
		System.out.println("PersonId:"+p.getPersonId());
		System.out.println("Name:"+p.getPersonName());
		System.out.println("Age:"+p.getPersonAge());
		System.out.println("PassportNo:"+pass.getPassportNo());
		System.out.println("IssueDate:"+pass.getIssueDate());
		System.out.println("ExpiryDate:"+pass.getExpiryDate());
		System.out.println("IssuePlace:"+pass.getPlaceOfIssue());
		
		
		
	}

}
