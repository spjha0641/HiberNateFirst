package com.lti.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.dao.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.OrderItem;

public class OrderMain {

	public static void main(String[] args) {
		GenericDao dao = new GenericDao();
	//	List<OrderItem> items = new ArrayList<OrderItem>();
		dao.fetchOrderDetails(225);
		
		/*
		 * List<OrderItem> items = new ArrayList<OrderItem>(); Order order=new Order();
		 * order.setOrderDate(LocalDate.of(2019, 12, 8)); order.setOrderPrice(750);
		 * 
		 * OrderItem item1 = new OrderItem(); item1.setOrder(order);
		 * item1.setPrice(400); item1.setQuantity(5);
		 * 
		 * OrderItem item2 = new OrderItem(); item2.setOrder(order);
		 * item2.setPrice(200); item2.setQuantity(2);
		 * 
		 * OrderItem item3 = new OrderItem(); item3.setOrder(order);
		 * item3.setPrice(350); item3.setQuantity(12);
		 * 
		 * items.add(item1); items.add(item2); items.add(item3);
		 * 
		 * 
		 * order.setItems(items);
		 * 
		 * dao.add(order);
		 */
	//	  Payment pay=new Payment();
	//	  Order od=new Order();
		  
		/*
		 * pay.setAmount(500); pay.setPaymentDate(LocalDate.of(2019, 12, 10));
		 * pay.setPaymentMode("cash on"); od.setOrderId(201); pay.setOrder(od);
		 */
		
		/*
		 * Order od=new Order(); od.setOrderDate(LocalDate.of(2019, 12, 10));
		 * od.setOrderPrice(500);
		 */
		  
		//dao.add(pay);
	
	}

}
