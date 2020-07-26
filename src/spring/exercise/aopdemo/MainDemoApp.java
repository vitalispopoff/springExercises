package spring.exercise.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.exercise.aopdemo.dao.AccountDAO;

public class MainDemoApp {
	
	public static void main (String[] args) {
									
		AnnotationConfigApplicationContext
			context = new AnnotationConfigApplicationContext(DemoConfig.class);					
		AccountDAO 
			accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		
		try {			
			accounts = accountDAO.findAccounts();
		}
		catch (Exception e) {System.out.println("\n > exception: " + e);
		
		System.out.println("\n...     Main :\n");		
		System.out.println("...     > "+ accounts+"\n");
								
		context.close();		 
	}
}