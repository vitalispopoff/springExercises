package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
	@Order(1)
public class MyApiAnalyticsAspect {
		
		@Before("forDao()")
	public void performApiAnalyticAdvice() {
		System.out.println("... > api analytics\n");
	}

}
