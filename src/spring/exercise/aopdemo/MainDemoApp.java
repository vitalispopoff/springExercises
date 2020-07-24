package spring.exercise.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.exercise.aopdemo.dao.*;

public class MainDemoApp {
	
	public static void main (String[] args) {
									
		AnnotationConfigApplicationContext										//	read spring cfg java class
			context = new AnnotationConfigApplicationContext(DemoConfig.class);
					
		AccountDAO																//	get the bean from spring container 
			accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO															//	...
			membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
					
		accountDAO.addAccount();												//	call the method of a component class		
		
//		membershipDAO.addSillyMember();											//	call the method of another component class

//		membershipDAO.addAccount();
		
		membershipDAO.addAnotherMember("string", membershipDAO);
		
				
		context.close();														//	close the context		
	}
}