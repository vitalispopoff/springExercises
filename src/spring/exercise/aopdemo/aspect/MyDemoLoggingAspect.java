package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
	@Order(2)
public class MyDemoLoggingAspect {
		
		
		// pointcuts moved to the AopExpressions

		@Before(expAddress+"forDao()") 
	public void beforeAddAccountAdvice() {		
		System.out.println("... > order 2 : 1st advice \n");
	}
}