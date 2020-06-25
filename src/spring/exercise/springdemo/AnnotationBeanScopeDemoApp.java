package spring.exercise.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		//		load spring configuration file

		ClassPathXmlApplicationContext context 
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//		retrieve bean from spring container
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//		check if the beans are the same
		
		boolean result = (theCoach == alphaCoach);
		
		//		print out the result
		
		System.out.println("... point to the same object ? "+result);
		
		System.out.println("... memory location for theCoach : "+theCoach);
		
		System.out.println("... memory location for alphaCoach : "+alphaCoach);
		
		//		close the context
		
		context.close();
	}
}