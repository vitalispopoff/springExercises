package spring.exercise.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.exercise.aopdemo.aspect.MyDemoLoggingAspect;
import spring.exercise.aopdemo.dao.*;

public class MainDemoApp {
	
	public static void main (String[] args) {
									
		AnnotationConfigApplicationContext
			context = new AnnotationConfigApplicationContext(DemoConfig.class);
					
		AccountDAO 
			accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO
			membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
					
		accountDAO.addAccount(new Account(),true);		
		
//		membershipDAO.addSillyMember();
//		membershipDAO.addAccount();
//		membershipDAO.addAnotherMember("string", membershipDAO);
//		membershipDAO.goToSleep();
		
		accountDAO.setAccount();
		
		membershipDAO.setAccount(new Account("Joe", "novice"));
		membershipDAO.getAccount();
		
						
		context.close();		
	}
}