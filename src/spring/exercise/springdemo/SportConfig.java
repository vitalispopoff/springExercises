package spring.exercise.springdemo;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("spring.exercise.springdemo")	// commenting it out as no autoscans are to be run 
public class SportConfig {

	//	define bean for the sadFortuneService
	
	@Bean	// beanId is sadFortuneService
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//	define bean for the SwimCoach and inject dependency
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}