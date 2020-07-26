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
			
			System.out.println("\n > > Case 1\n");
			accounts = accountDAO.findAccounts(false);
			System.out.println("\n > > Case 2\n");
			accounts = accountDAO.findAccounts(true); 
		}
		catch (Exception e) {System.out.println("\n > main catch exception: " + e);}
		
		System.out.println("\n...     Main :\n");		
		System.out.println("...     > "+ accounts+"\n");
								
		context.close();		 
	}
}