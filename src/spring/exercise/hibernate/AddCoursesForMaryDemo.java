package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class AddCoursesForMaryDemo {
		
	/**
	 * 1. create students
	 * 2. add students to the course
	 * 3. save the students
	 */
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static Course
		tempCourse = new Course("Pacman - How To Score One Million Points");
	
	
	static Student
		tempStudent1 = new Student("John", "Doe", "john.doe@gmail.com"),
		tempStudent2 = new Student("Mary", "Public", "mary@public-enemy.com");
	

	//		the difference between this code and the original code is that the adding the students happens outside the transaction. worth checking whether it matters. TODO	
	static {
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
	}
		
//	
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			session.save(tempCourse);
			session.save(tempStudent1);
			session.save(tempStudent2);
						
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {
			terminating();			
			}
	}
}