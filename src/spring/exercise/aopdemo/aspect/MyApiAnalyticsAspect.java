package spring.exercise.aopdemo.aspect;

import static spring.exercise.aopdemo.aspect.AopExpressions.expAddress;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

	@Aspect
	@Component
	@Order(3)
public class MyApiAnalyticsAspect {		
		
	private Logger
		logger = Logger.getLogger(getClass().getName());	
		
		@Before(expAddress+"forDao()")
	public void performApiAnalyticAdvice() {
		logger.info("... > order 3 : api analytics\n");
	}

}
