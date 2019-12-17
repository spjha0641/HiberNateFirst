package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class AccountService {
	AccountDao accDao = new AccountDao();
	
	public boolean openAnAccount(Account acc) {
		boolean b=false;
		if(acc.getAccBal()>10000) {
			b=accDao.addAnAccount(acc);
		}
		return b;
	}
	
	public double checkBalance(int accNum) {
		Account acc=accDao.fetchAccount(accNum);
		return acc.getAccBal();
		
	}
	
	public double withdrawMoney(int accnum, double amount) {
		Account acc=accDao.fetchAccount(accnum);
		double bal= acc.getAccBal();
		if(amount<bal)
			return accDao.withdrawFromAccount(acc, amount);
		else
			return bal;
			
	}

	public boolean withdraw(int fromAcc, double amount) {
		Account acc=accDao.fetchAccount(fromAcc);
		if(acc.getAccBal()>=amount) {
			//Adding a transaction
			Transaction t = new Transaction();
			t.setAccount(acc);
			t.setAmount(amount);
			t.setTxnType("withdraw");
			
			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(t);
			
			//Updating the account
			acc.setAccBal(acc.getAccBal()- amount);
			acc.setTransactions(transactions);
			accDao.save(acc);
			
			return true;
		}
		return false;
			
	}
	
	public boolean deposit(int toAcc, double amount) {
		Account ac =accDao.fetchAccount(toAcc);
		
		Transaction t = new Transaction();
		t.setAccount(ac);
		t.setAmount(amount);
		t.setTxnType("deposit");
		
		List<Transaction> transactions= new ArrayList<Transaction>();
		transactions.add(t);
		
		ac.setAccBal(ac.getAccBal()+amount);
		ac.setTransactions(transactions);
		accDao.save(ac);
		
		return true;
		
		
	}
	
	public boolean transfer(int fromAcc, int toAcc, double amount) {
		Account ac1 =accDao.fetchAccount(fromAcc);
		Account ac2 =accDao.fetchAccount(toAcc);
		List<Transaction> transactions= new ArrayList<Transaction>();
		
		if(ac1.getAccBal()>=amount) {
			Transaction t1 = new Transaction();
			t1.setAccount(ac1);
			t1.setAmount(amount);
			t1.setTxnType("withdraw from");	
			
			transactions.add(t1);
			ac1.setAccBal(ac1.getAccBal()-amount);
			ac1.setTransactions(transactions);
			accDao.save(ac1);
			
			Transaction t2 = new Transaction();
			t2.setAccount(ac2);
			t2.setAmount(amount);
			t2.setTxnType("deposit to");
			
			transactions.add(t2);
			ac2.setAccBal(ac2.getAccBal()+amount);
			ac2.setTransactions(transactions);
			accDao.save(ac2);
			return true;
		}
		
		return false;
	}
	
	public List<Transaction> fetchMiniStatement(int accNum) {
		Account ac=accDao.fetchAccount(accNum);
		
		List<Transaction> trans= new ArrayList<Transaction>();
		trans= ac.getTransactions();
		
		return trans;
		
		
	}
	

}
