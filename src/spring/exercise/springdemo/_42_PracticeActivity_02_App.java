package spring.exercise.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _42_PracticeActivity_02_App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext ("applicationContext.xml");
		
		SumoCoach sumo = context.getBean("mySumoCoach", SumoCoach.class);
		
		System.out.println(sumo.getDailyFortune());
		
		context.close();
		

	}

}
