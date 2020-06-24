package spring.exercise.springdemo;

public class HappyFortuneService implements FortuneService{
	
	public HappyFortuneService() {
		super();
		System.out.println("CricketCoach > HappyFrotuneService : no-arg constructor");
	}

	@Override
	public String getFortune() {
		
		return "Today is your lucky day!";
		
	}
}