package spring.exercise.aopdemo.dao;

import org.springframework.stereotype.Component;

import spring.exercise.aopdemo.Account;

@Component
public class MembershipDAO {
	
	Account 
		account;
		
	public void addAccount() {
		
		System.out.println(""+getClass()+"> addAccount method in progress");
	}
	
	public void addSillyMember() {
		
		System.out.println("that maaaaad mate...");
	}	
	
	public void addAnotherMember(String string, MembershipDAO accountDAO) {
		System.out.println("method w/ 1 explicit parameter, and another as '*' ");
	}
	
	public void goToSleep() {
		System.out.println("S l E E P !");
	}
	
	public void setAccount(Account account) {
		
		this.account = account;
		System.out.println("account set");
	}
	
	public Account getAccount() {
		
		System.out.println("returning: "+account);
		return account;
	}
}