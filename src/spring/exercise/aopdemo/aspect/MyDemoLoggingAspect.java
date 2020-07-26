package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
				
		//	display method args
		
		
		
	}
}