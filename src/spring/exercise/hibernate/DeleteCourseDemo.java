package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;


public class DeleteCourseDemo {
			
	static int 
		tempInstructorId = 1,
		tempCourseId = 1;
	
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
			
			//	get a course
			
			tempCourse1 = session.get(Course.class, tempCourseId);
			
			System.out.println("deleting the course: "+tempCourse1);
			
			// delete the course
			session.delete(tempCourse1);
			
			
			
			// commit			
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}

}