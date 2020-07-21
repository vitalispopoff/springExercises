package _outs;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;
//import hibernate.exercise.demo.entity.Instructor;
//import hibernate.exercise.demo.entity.InstructorDetail;

public class CreateCoursesDemo {
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static Course
		tempCourse1 = new Course("Air Guitar - The Ultimate Guide"),
		tempCourse2 = new Course("The Pinball Masterclass");
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			//	retrieve the instructor			
			tempInstructor = session.get(Instructor.class, tempInstructorId);
			
			//	add courses to the instructor 
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
					
			//	saving the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
//			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}

}