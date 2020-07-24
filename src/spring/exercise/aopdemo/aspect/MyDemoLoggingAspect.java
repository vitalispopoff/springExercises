package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
public class MyDemoLoggingAspect {
		
		@Pointcut("execution(public void spring.exercise.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
		
		@Before("forDaoPackage()")	// 
	public void beforeAddAccountAdvice() {
		
		System.out.println("... > @Before via @Pointcut ");
	}
		
		@After("forDaoPackage()")
	public void afterAddAccountAdvice() {

		System.out.println("... > @After via @Pointcut ");
	}
}