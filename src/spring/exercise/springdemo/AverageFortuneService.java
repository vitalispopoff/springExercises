package spring.exercise.springdemo;

import java.util.Random;

public class AverageFortuneService implements FortuneService {

	private static String[] fortuneServiceBase = { 
			"Yeah, whatever.", 
			"Tommorow's a day too.",
			"You've improved your statistical average perfomrance, and that's so-so.",
			"For every great result You're gonna make many lame attempts, keep the records for the games.",
			"Everything is a competition. Your fail may be asuccess in a discipline or two." };

	@Override
	public String getFortune() {
		Random random = new Random();
		int i = random.nextInt(5);

		return fortuneServiceBase[i];
	}
}