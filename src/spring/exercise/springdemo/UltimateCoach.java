package spring.exercise.springdemo;

public class UltimateCoach implements Coach {
	
	
//	@Autowired
//	@Qualifier("ultimateFortuneService")
	private FortuneService 
		fortuneService;
	
	public UltimateCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}