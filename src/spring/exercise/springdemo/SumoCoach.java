package spring.exercise.springdemo;

public class SumoCoach implements Coach {
	
	private FortuneService
		fortuneService;
	
	public SumoCoach() {
		System.out.println("... SumoCoach : constructor");
	}
	
	

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Gain 50 pounds of a body mass";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
		
	}
}