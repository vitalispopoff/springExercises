package _outs;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class CreateCoursesAndReviewsDemo {
		
	/**
	 * 1. create a course
	 * 2. add reviews
	 * 3. save the course along with the reviews
	 */
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static Course
		tempCourse = new Course("Pacman - How To Score One Million Points");
		
	static {
		tempCourse.addReview(new Review("Great course"));
		tempCourse.addReview(new Review("so so"));
		tempCourse.addReview(new Review("what a waste of time"));
	}
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			session.save(tempCourse);
						
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {
			terminating();			
			}
	}
}