//	@formatter:off

package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class DeleteCoursesAndReviewsDemo {
		
	/**
	 * 1. get a course
	 * 2. delete course
	 */
			
	static int 
		tempInstructorId = 1,
		tempCourseId = 10;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static Course
		tempCourse;

	public static void main(String[] args) {
		
		try {
			initializing();
		
			tempCourse = session.get(Course.class, tempCourseId); 
			
			session.delete(tempCourse);
									
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}
}

//	@formatter:on