package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
public class MyDemoLoggingAspect {

	//	it's where all of the related advices for logging are stored
		
	
		
	//	starting with an @Before advice
		
		@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("... beforeAddAccountAdvice execution w/ @Before advice on addAccount method");
	}
	
}