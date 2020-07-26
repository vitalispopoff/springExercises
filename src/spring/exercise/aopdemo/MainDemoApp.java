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
		List<Account> 
			accounts = null;
		
		try {			
			//	adding a boolean flag to simulate exception
			boolean 
				tripWire = true;
			
			accounts = accountDAO.findAccounts(tripWire); 
		}
		catch (Exception e) {System.out.println("\n > main catch exception: " + e);}
		
		System.out.println("\n...     Main :\n");		
		System.out.println("...     > "+ accounts+"\n");
								
		context.close();		 
	}
}