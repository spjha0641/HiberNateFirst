package com.lti.main;

import java.time.LocalDate;

import com.lti.dao.EmployeeDao;
import com.lti.entity.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setName("Satya");
		emp.setSalary(25000);
		emp.setDateOfJoining(LocalDate.of(2019,10,29));
		
		EmployeeDao dao=new EmployeeDao();
		dao.addEmployee(emp);
	}

}
