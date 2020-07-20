package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;
import java.util.*;

public class EagerLazyDemo {
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static List<Course>
	tempCourses/* = new LinkedList<>() */;
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			tempInstructor = session.get(Instructor.class, tempInstructorId);	
			
			tempCourses = tempInstructor.getCourses();					// this on itself doesn't seem to guarantee a proper loading. why?
			System.out.println(tempCourses.size());
//			for(Course course : tempInstructor.getCourses());
			
//			String temporal = tempInstructor.getCourses().toString();	// anything that connects the course tuples to the context should be enough to keep them in the memory
//			System.out.println(tempInstructor.getCourses());			// ... 

			finalizing();
			
			System.out.println("... done.");
						
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
		
//		System.out.println("... Courses: "+ tempInstructor.getCourses());
//		tempCourses = tempInstructor.getCourses();
//		for(Course course : tempCourses)System.out.println(course);
		System.out.println(tempCourses.size());
//		System.out.println(tempCourses.toString());
	}
	
}