package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
	@Component
	@Order(1)
public class MyCloudLogAsyncAspect {
	
		@Before("forDao()")
	public void logToCloudAdvice() {
		System.out.println("... > loggin' to Cloud\n");
	}

}