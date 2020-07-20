package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class EagerLazyDemo {
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static Course
		tempCourse1,
		tempCourse2;
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			//	retrieve the instructor 
			tempInstructor = session.get(Instructor.class, tempInstructorId);	
			
			System.out.println("... Instructor : "+tempInstructor);
			
			//	due to the the Instructor.courses fetch=FetchType.Lazy annotation, the courses are loaded upon request only.
			System.out.println("... Courses: "+ tempInstructor.getCourses());
						
			finalizing();
			System.out.println("... done.");
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}

}