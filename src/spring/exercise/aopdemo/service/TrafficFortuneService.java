package spring.exercise.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

	@Component
public class TrafficFortuneService {
	
	public String getFortune() {				
		try { 
			TimeUnit.SECONDS.sleep(5); 
		}
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		
		return "expect heavy traffic";
	}

	public String getFortune(boolean throwException) {		
		if (throwException) 
			throw new RuntimeException ("Wait. What?");
		
		return getFortune();
	}
}