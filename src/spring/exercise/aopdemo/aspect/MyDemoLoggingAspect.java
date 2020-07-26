package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
	@Order(1)
public class MyDemoLoggingAspect {
		
		// pointcuts moved to the AopExpressions

		@Before("forDao()") 
	public void beforeAddAccountAdvice() {		
		System.out.println("... > 1st advice \n");
	}
}