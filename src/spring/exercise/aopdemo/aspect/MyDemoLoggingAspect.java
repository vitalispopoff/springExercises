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
		
	private final String
		localExpAddress = "execution(* spring.exercise.aopdemo.dao.AccountDAO.findAccounts(..))";
				
		@AfterThrowing(
				pointcut = localExpAddress,
				throwing = "exception")
	public void afterThrowExceptionFindAccountAdvice(
			JoinPoint joinPoint,
			Throwable exception) {
		
		//	printing the method being advised
		String
			method = joinPoint.getSignature().toShortString();
		
		System.out.println("    > @AfterThrowing\n      > "+ method);
			
		//	logging the exception
		System.out.println("    > threw :\n      > " + exception);				
	}
		
		@AfterReturning(
				pointcut = localExpAddress,
				returning = "result")
	public void afterReturningFindAccountAdvice(
			JoinPoint joinPoint,
			List<Account> result) {
						
		String 
			method = joinPoint.getSignature().toShortString();

		System.out.println("    > @AfterReturning\n      > "+ method);
		System.out.println("    > returned :\n      > " + result);			
		
		//	post-process the result:
		//		uppercase the account names 
		convertToUpperCase(result);
	}
		
	private void convertToUpperCase(List<Account> result) {
		for(Account account : result)
			account.setName(account.getName().toUpperCase());
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
				Account 
					account = (Account) cache;
				
				System.out.println("   ... account name: "+ account.getName());
				System.out.println("   ... account level: "+ account.getLevel());
			}
		}
	}
}