package spring.exercise.springdemo.mvc.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//	define default course code
	public String value() default "LUV";
	
	//	define default error message
	public String message() default "must start with LUV";
	
	//	define default groups
	public Class<?>[] groups() default {};
	
	
	//	define default payloads
	public Class<? extends Payload>[] payload() default {};

}