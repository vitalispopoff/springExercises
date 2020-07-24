package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
public class MyDemoLoggingAspect {
		
		@Before("execution(public void spring.exercise.aopdemo.dao.*.*(..))")	// 
	public void beforeAddAccountAdvice() {
		
		System.out.println("... @Before access return package method (input, input) ");
	}
		
		@After("execution(* add*(String, * ))")
	public void afterAddAccountAdvice() {

		System.out.println("... @After: * add* (input_1 , *) ");
	}
}