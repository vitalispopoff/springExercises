package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import spring.exercise.aopdemo.Account;

	@Aspect
	@Component
	@Order(2)
public class MyDemoLoggingAspect {
		
	private Logger
		logger = Logger.getLogger(getClass().getName());	
	
	private final String
		localExpAddress = "execution(* spring.exercise.aopdemo.dao.AccountDAO.findAccounts(..))",
		localExpAddress2 = "execution(* getFortune(..))";
			
		@Around(localExpAddress2)
	public Object aroundFortuneAdvice(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
			String
				method = proceedingJoinPoint.getSignature().toShortString();			
			logger.info("\n      > @Around\n      > " + method);
						
			long
				initialTime = System.currentTimeMillis();			
			Object 
				result = null; 			
			
			try {
				result = proceedingJoinPoint.proceed();
			} 
			catch (Exception  e) {
				
				// log exception
				logger.warning(e.getMessage());
				
				// give custom message
				result = "crap.";
			}
			
			long
				terminalTime = System.currentTimeMillis();
			
			logger.info("\n      > duration : " + (terminalTime - initialTime) + "ms");
			
		return result;
	}
		
		@After(localExpAddress)
	public void afterRegardlessAccountAdvice() {
			logger.info("\n    > @After - so just you know when it fires.");
	}
	
		@AfterThrowing(
				pointcut = localExpAddress,
				throwing = "exception")
	public void afterThrowExceptionFindAccountAdvice(
			JoinPoint joinPoint,
			Throwable exception) {
		
		String
			method = joinPoint.getSignature().toShortString();
		
		logger.info("\n      > @AfterThrowing\n      > "
							+ method
							+ "\n      > threw :\n      > " 
							+ exception);				
	}
				
		@AfterReturning(
				pointcut = localExpAddress,
				returning = "result")
	public void afterReturningFindAccountAdvice(
			JoinPoint joinPoint,
			List<Account> result) {
						
		String 
			method = joinPoint.getSignature().toShortString();

		logger.info("\n      > @AfterReturning\n      > "
							+ method
							+"\n      > returned :\n      > " 
							+ result);
		
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
		
		logger.info("\n      > order 2 : 1st advice \n"
							+ "\n\n > Method: " 
							+ methodSignature);
				 		
		Object[] 
			args = joinPoint.getArgs();
		
		for (Object cache : args) {
			logger.info("\n   : " + cache);
			
			if(cache instanceof Account) {				
				Account 
					account = (Account) cache;
				
				logger.info("\n   ... account name: "
									+ account.getName()
									+ "\n   ... account level: "
									+ account.getLevel());
			}
		}
	}
}