package spring.exercise.springdemo;

import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {

	@Override
	public String getDailyWorkout() {	
		return "Analyze all possible responses for the openings of a particular games";
	}
}