package spring.exercise.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println("... "+getClass()+"> addAccount method in progress");
	}
	
	public void addSillyMember() {
		
		System.out.println("... that maaaaad mate...");
	}

}
