package spring.exercise.springdemo;

import org.springframework.stereotype.Component;

@Component
public class UltimateFortuneService implements FortuneService {
	
	@Override
	public String getFortune() {

		return "You! Shall! SucceeEED!";
	}

}
