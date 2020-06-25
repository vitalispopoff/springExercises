package spring.exercise.springdemo;

import org.springframework.context.annotation.*;

@Configuration
public class UltimateConfig {

	@Bean
	public FortuneService ultimateFortuneService() {
		return new UltimateFortuneService();
	}

	@Bean
	public Coach ultimateCoach() {
		return new UltimateCoach(ultimateFortuneService());
	}
}