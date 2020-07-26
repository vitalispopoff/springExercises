package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
	@Component
	@Order(1)
public class MyCloudLogAsyncAspect {
	
		@Before(expAddress+"forDao()")
	public void logToCloudAdvice() {
		System.out.println("... > order 1 : loggin' to Cloud\n");
	}

}