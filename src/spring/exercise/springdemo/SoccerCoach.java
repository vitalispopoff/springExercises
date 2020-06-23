package spring.exercise.springdemo;

public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Penalty kick drill: Perform 100 direct hits of a designated foot square area target from a distance of 70 yards";
	}

	@Override
	public String getDailyFortune() {
		
		return null;
		
	}
}