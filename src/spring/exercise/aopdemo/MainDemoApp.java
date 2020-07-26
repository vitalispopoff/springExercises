package spring.exercise.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.exercise.aopdemo.service.TrafficFortuneService;

public class MainDemoApp {
	
	private static Logger 
		logger = Logger.getLogger(MainDemoApp.class.getName());
	
	public static void main (String[] args) {
									
		AnnotationConfigApplicationContext
			context = new AnnotationConfigApplicationContext(DemoConfig.class);					
		TrafficFortuneService 
			fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);		
		
		logger.info("\n main > ");
		
		String 
			data = fortuneService.getFortune();
		
		logger.info("      > " 
					+ data
					+ "\n    done >\n");
										
		context.close();		 
	}
}