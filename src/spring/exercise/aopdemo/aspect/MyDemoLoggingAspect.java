package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import spring.exercise.aopdemo.Account;

	@Aspect
	@Component
	@Order(2)
public class MyDemoLoggingAspect {
		
		@Before(expAddress+"forDao()") 
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {		

		System.out.println("... > order 2 : 1st advice \n");
		
		//	display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("\n > Method: " + methodSignature);
				
		//	display method args : 
		
		Object[] args = joinPoint.getArgs();
		
		for (Object cache : args) {
			System.out.println("   : " + cache);
			
			if(cache instanceof Account) {
				
				// downcast and print the Account class specific data
				Account account = (Account) cache;
				
				System.out.println("   ... account name: "+ account.getName());
				System.out.println("   ... account level: "+ account.getLevel());
			}
		}
		
		
		
		
		
	}
}