package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;


public class GetInstructorCoursesDemo {
			
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
			
			System.out.println("Instructor : "+tempInstructor);
			System.out.println("Courses: "+ tempInstructor.getCourses());
			
			
			
			
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}

}