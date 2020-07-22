package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class GetCoursesForMaryDemo {
		
	/**
	 * 1. create students
	 * 2. add students to the course
	 * 3. save the students
	 */
					
	
	static int 
		tempStudentId = 2;
	
	static Student
//		tempStudent1,
//		tempStudent2,
		tempStudent;
	
	
		
//	
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			tempStudent = session.get(Student.class, tempStudentId);
			
			for(Course course : tempStudent.getCourses());	// keep in mind - fetch=FetchType.LAZY, that's this one is needed for line 46 to work
			
//			for(Course course : session.get(Student.class, tempStudentId).getCourses())System.out.println(course); // this one instead of 33/35/46 works as well.
			
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {
			terminating();			
			}
		
		System.out.println(tempStudent.getCourses());
		
	}
}