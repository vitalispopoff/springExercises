package spring.exercise.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.exercise.aopdemo.dao.AccountDAO;
import spring.exercise.aopdemo.service.TrafficFortuneService;

public class MainDemoApp {
	
	public static void main (String[] args) {
									
		AnnotationConfigApplicationContext
			context = new AnnotationConfigApplicationContext(DemoConfig.class);					
		TrafficFortuneService 
			fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);		
		
		System.out.println("\n main > ");
		
		String data = fortuneService.getFortune();
		System.out.println("      > " + data);
		System.out.println(" done >\n");
		
								
		context.close();		 
	}
}