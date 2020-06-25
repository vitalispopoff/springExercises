package spring.exercise.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(" ..."+this.getClass()+" : default contructor");
	}
		
	//	define my init method
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(" ..."+this.getClass()+ " : @postConstruct - doMyStartupStuff ");
	}
	
	//	define my destroy method
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(" ..."+this.getClass()+ " : @PreDestroy - doMyCleanupStuff ");
	}
		
	/* parameterized constructor
	 *
	 * @Autowired public TennisCoach(FortuneService fortuneService) { super();
	 * this.fortuneService = fortuneService; }
	 */
	
	/*	autowired setter
	 * // define a setter method
	 * 
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println(" ... "+this.getClass()+" : doSomeCrazyStuff");
	 * this.fortuneService = fortuneService; }
	 * 
	 */
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}