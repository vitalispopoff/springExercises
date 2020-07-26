package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import java.util.List;

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
		
		// an advice to show off the @AfterReturning
		@AfterReturning(
				pointcut = "execution(* spring.exercise.aopdemo.dao.AccountDAO.findAccounts())",
				returning = "result")
	public void afterReturningFindAccountAdvice(
			JoinPoint joinPoint,
			List<Account> result) {
			
		// print out the advised method			
		String 
			method = joinPoint.getSignature().toShortString();
		System.out.println("        > @AfterReturning\n          > "+ method);
			
		// print out the result of the advised method.
		System.out.println("        > returned :\n          > " + result);
		
		
			
		}
		
		@Before(expAddress+"forDao()") 
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {		
		
		MethodSignature 
			methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("... > order 2 : 1st advice \n");		
		System.out.println("\n > Method: " + methodSignature);
				 		
		Object[] 
			args = joinPoint.getArgs();
		
		for (Object cache : args) {
			System.out.println("   : " + cache);
			
			if(cache instanceof Account) {
				
				Account account = (Account) cache;
				
				System.out.println("   ... account name: "+ account.getName());
				System.out.println("   ... account level: "+ account.getLevel());
			}
		}		
	}
}