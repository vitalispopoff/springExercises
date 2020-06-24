package spring.exercise.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

//		load the spring configuration file

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

//		retrieve bean from spring container - why having the bean id w/ established class the context needs CricketCoach.class ?
		
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

//		call methods
		
//		to be done later.
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeam());

//		close the context
		
		context.close();

	}
}