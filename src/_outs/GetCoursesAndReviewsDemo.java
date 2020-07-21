//	@formatter:off

package _outs;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class GetCoursesAndReviewsDemo {
		
	/**
	 * 1. get a course
	 * 2. print the course
	 * 3. print the course reviews
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
			
			for(Review review : tempCourse.getReviews());	// need this to force the review loading
									
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
		
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}
}

//	@formatter:on