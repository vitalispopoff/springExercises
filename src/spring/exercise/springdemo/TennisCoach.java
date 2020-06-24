package spring.exercise.springdemo;

import org.springframework.stereotype.Component;

@Component // the annotations uses the default bean id ("tennisCoach") now
public class TennisCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
}