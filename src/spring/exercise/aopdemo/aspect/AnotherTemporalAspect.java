package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnotherTemporalAspect {

		@Before("execution(* *Account*(..))")
	public void whatever() {
			System.out.println(" > another Aspect run!");
		}
}