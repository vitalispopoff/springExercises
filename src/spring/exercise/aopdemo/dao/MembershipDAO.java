package spring.exercise.aopdemo.dao;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import spring.exercise.aopdemo.Account;

@Component
public class MembershipDAO {
	
	private Logger
		logger = Logger.getLogger(getClass().getName());	
	
	Account 
		account;
		
	public void addAccount() {		
		logger.info(""+getClass()+"> addAccount method in progress");
	}
	
	public void addSillyMember() {		
		logger.info("that maaaaad mate...");
	}	
	
	public void addAnotherMember(String string, MembershipDAO accountDAO) {
		logger.info("method w/ 1 explicit parameter, and another as '*' ");
	}
	
	public void goToSleep() {
		logger.info("S l E E P !");
	}
	
	public void setAccount(Account account) {		
		this.account = account;
		logger.info("account set");
	}
	
	public Account getAccount() {		
		logger.info("returning: "+account);
		return account;
	}
}