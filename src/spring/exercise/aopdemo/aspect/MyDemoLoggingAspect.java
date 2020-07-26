package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
public class MyDemoLoggingAspect {
		
	private final String
		exp_01 = "execution(public void spring.exercise.aopdemo.dao.*.",
		exp_02 =  exp_01 + "*(..))";
	
		@Pointcut(exp_02)
	private void forDao() {}
																
		@Pointcut(exp_01 + "get*(..))")									//	pointcut for getter methods in dao
	private void getters() {}
		
		@Pointcut(exp_01 + "set*(..))")									//	pointcut for setter methods in dao
	private void setters() {}
		
		@Pointcut("forDao() && !getters() && !setters()")	//	pointcut incl. expression and excl. getters, setters
	private void forDaoWithoutGetSet() {}

		@Before("forDao()") 
	public void beforeAddAccountAdvice() {		
		System.out.println("... > @Before via @Pointcut ");
	}
		
		@After("forDao()")
	public void afterAddAccountAdvice() {
		System.out.println("... > @After via @Pointcut ");
	}
}