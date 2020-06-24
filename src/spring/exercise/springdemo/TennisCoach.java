package spring.exercise.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // the annotations uses the default bean id ("tennisCoach") now
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TennisCoach() {}
	
	@Autowired	// calls spring to look for the interface/class declaring/implementing the fortuneService
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}