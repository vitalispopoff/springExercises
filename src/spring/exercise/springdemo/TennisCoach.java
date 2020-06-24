package spring.exercise.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(" ... "+this.getClass()+" : default contructor");
	}
		
	/* parametrized constructor
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