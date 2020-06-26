package spring.exercise.springdemo.mvc.validation;

import javax.validation.*;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {		
		coursePrefix = theCourseCode.value();		
	}
		
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean 
			result = theCode == null ? true : theCode.startsWith(coursePrefix);
		
		return result;
	}
}