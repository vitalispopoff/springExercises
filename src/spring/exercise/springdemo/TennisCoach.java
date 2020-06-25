package spring.exercise.springdemo;

import javax.annotation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(" ..."+this.getClass()+" : default contructor");
	}
		
	//	define my initial method
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(" ..."+this.getClass()+ " : @postConstruct - doMyStartupStuff ");
	}
	
	//	define my destroy method
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(" ..."+this.getClass()+ " : @PreDestroy - doMyCleanupStuff ");
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