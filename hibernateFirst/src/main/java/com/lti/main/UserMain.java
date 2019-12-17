package com.lti.main;

import com.lti.dao.UserDao;
import com.lti.entity.Address;
import com.lti.entity.User;

public class UserMain {

	public static void main(String[] args) {
		UserDao dao=new UserDao();
		User u=new User();
		
		Address ad=new Address();
		ad.setAddrId(104);
		ad.setAddrLine("Gandhi Nagar");
		dao.addAddress(ad);
		
		int id=ad.getAddrId();
		u.setUserName("Prajjwal");
		dao.addUserWithAddress(u, id);
				
	}

}
