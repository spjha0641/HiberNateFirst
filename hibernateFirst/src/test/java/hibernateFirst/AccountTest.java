package hibernateFirst;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountTest {
	AccountService service = new AccountService();
	
	@Test
	public void testAddAccount() {
		Account ac= new Account();
		ac.setAccName("Raza");
		ac.setAccType("Savings");
		ac.setAccBal(5000);
		
		boolean msg= service.openAnAccount(ac);
		
		if(msg == true)
			System.out.println("Account opened successfully");
		else
			System.out.println("Failed");
	}
	
	@Test
	public void testCheckBalance() {
		System.out.println(service.checkBalance(301));
	}
	
	@Test
	public void testWithdraw() {
		if(service.withdraw(301, 500))
			System.out.println("Withdrawal successul");
		else
			System.out.println("Transaction unsuccessful");
	}
	
	@Test
	public void testDeposit() {
		if(service.deposit(266, 500))
			System.out.println("Deposited");
		else
			System.out.println("Transaction unsuccessful");
	}

	@Test
	public void testTransfer() {
		//from and to
		if(service.transfer(266, 281, 1000))
			System.out.println("Transferred");
		else
			System.out.println("Transaction unsuccessful");
	}
	
	@Test
	public void testMiniStmt() {
		List<Transaction> trans = new ArrayList<Transaction>();
		trans= service.fetchMiniStatement(301);
		
		for(Transaction t: trans) {
			System.out.println(t.getTxnId()+" : "+t.getTxnType()+" : "+t.getAmount());
		}
	}

}
