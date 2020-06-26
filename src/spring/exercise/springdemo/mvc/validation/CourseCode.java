package spring.exercise.springdemo.mvc.validation;

import java.lang.annotation.*;
import javax.validation.Constraint;

//@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

}
