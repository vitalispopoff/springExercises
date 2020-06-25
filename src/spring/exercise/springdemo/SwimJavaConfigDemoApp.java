package spring.exercise.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container		
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//		call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//	call the SwimCoach specific methods: email, team
		
		System.out.println("email : "+theCoach.getEmail());
		
		System.out.println("team : "+theCoach.getTeam());
		
		// close the bean
		context.close();
	}
}