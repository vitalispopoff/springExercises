package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
	@Order(3)
public class MyApiAnalyticsAspect {		
		
		@Before(expAddress+"forDao()")
	public void performApiAnalyticAdvice() {
		System.out.println("... > order 3 : api analytics\n");
	}

}
