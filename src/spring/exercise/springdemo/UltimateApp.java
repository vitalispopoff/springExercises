package spring.exercise.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UltimateApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(UltimateConfig.class);

		Coach theCoach = context.getBean("ultimateCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
	}
}