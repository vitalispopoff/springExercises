package spring.exercise.aopdemo.dao;

import java.util.*;

import org.springframework.stereotype.Component;

import spring.exercise.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String
		name,
		serviceCode;
	
	 public List<Account> findAccounts(boolean tripWire) {
		 		 
		 if (tripWire) {
			 throw new RuntimeException("No soup for you!");
		 }
		 List<Account> 
		 	accounts = new ArrayList<>();		 
		 Account
		 	temp1 = new Account("John", "Silver"),
		 	temp2 = new Account("Madhu", "Admin"),
		 	temp3 = new Account("Saddhu", "Coffee");
		 
		 accounts.add(temp1);
		 accounts.add(temp2);
		 accounts.add(temp3);
		 
		 return accounts;		 
	 }
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": addAccount method init");
	}
	
	public void setAccount() {
		System.out.println("account set");
	}

}