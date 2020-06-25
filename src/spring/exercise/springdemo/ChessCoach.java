package spring.exercise.springdemo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {
	
	@Autowired
	@Qualifier("databaseFortuneService")
	FortuneService
		fortuneService;

	@Override
	public String getDailyWorkout() {	
		return "Analyze all possible responses for the openings of a particular games";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}	
}