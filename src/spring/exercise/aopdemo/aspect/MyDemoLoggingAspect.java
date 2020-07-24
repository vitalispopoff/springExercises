package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
public class MyDemoLoggingAspect {

	//	it's where all of the related advices for logging are stored
		
			
	//	starting with an @Before advice
			/**
			 * what's under the hood : 
			 * execution(
			 *  public - access modifier
			 *  void - return type
			 *  spring.exercise.aopdemo.dao.AccountDAO.addAccount - fully qualified address . method name
			 *  (
			 *  spring.exercise.aopdemo.Account - fully qualified address of a input parameter type
			 *  ))
			 */
		
		@Before("execution(public void spring.exercise.aopdemo.dao.AccountDAO.addAccount(spring.exercise.aopdemo.Account))")	// 
	public void beforeAddAccountAdvice() {
		
		System.out.println("... @Before access return package method (input) ");
	}
		
			/**
			 * what's under the hood :
			 * execution(
			 *  * - return type
			 *  add* - method name
			 *  (
			 *  String - first input type
			 *  ,
			 *  * - other input type
			 *  ))
			 */		
		
		@After("execution(* add*(String, * ))")
	public void afterAddAccountAdvice() {

		System.out.println("... @After: * add* (input_1 , *) ");
	}
}