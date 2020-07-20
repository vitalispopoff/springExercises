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
			
			//	retrieve the instructor - because of the FetchType.EAGER at Instructor.courses, the statement includes loading the course tuples from DB
			tempInstructor = session.get(Instructor.class, tempInstructorId);	
			
			System.out.println("... Instructor : "+tempInstructor);
			System.out.println("... Courses: "+ tempInstructor.getCourses());
						
			finalizing();
			System.out.println("... done.");
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}

}