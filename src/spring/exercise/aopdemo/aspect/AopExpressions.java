package spring.exercise.aopdemo.aspect;

import org.aspectj.lang.annotation.*;

	@Aspect
public class AopExpressions {
		
		private final String
		exp_01 = "execution(public void spring.exercise.aopdemo.dao.*.",
		exp_02 =  exp_01 + "*(..))";
	
		@Pointcut(exp_02)
	public void forDao() {}
																
		@Pointcut(exp_01 + "get*(..))")
	public void getters() {}
		
		@Pointcut(exp_01 + "set*(..))")
	public void setters() {}
		
		@Pointcut("forDao() && !getters() && !setters()")
	public void forDaoWithoutGetSet() {}
}