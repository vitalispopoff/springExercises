package spring.exercise.aopdemo.dao;

import org.springframework.stereotype.Component;

import spring.exercise.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": addAccount method init");
	}
	
	public void doWork() {
		System.out.println("DO WORK!");
	}
}