package spring.exercise.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.exercise.aopdemo.dao.AccountDAO;

public class MainDemoApp {
	
	public static void main (String[] args) {
							
		AnnotationConfigApplicationContext										//	read spring cfg java class
			context = new AnnotationConfigApplicationContext(DemoConfig.class);
			
		AccountDAO																//	get the bean from spring container 
			accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		accountDAO.addAccount();												//	call the business method
		
		context.close();														//	close the context		
	}
}