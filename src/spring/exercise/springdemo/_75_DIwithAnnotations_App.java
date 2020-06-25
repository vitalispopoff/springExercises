package spring.exercise.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _75_DIwithAnnotations_App {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach
			anotherCoach = context.getBean("chessCoach", Coach.class);
		
		System.out.println(anotherCoach.getDailyFortune());	
	}
}