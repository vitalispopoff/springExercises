package spring.exercise.aopdemo.dao;

import org.springframework.stereotype.Component;

import spring.exercise.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		
		System.out.println(getClass() + ": addAccount method in execution");
	}
}