package spring.exercise.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
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
}