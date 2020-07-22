package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class List_CourseAndStudentsDemo {
		
	/**
	 * 1. get student Mary from DB
	 * 2. create courses for Mary
	 * 3. add Mary to the courses
	 * 4. save the courses
	 */
			
	static int 
		tempStudentId = 2;
	
	static Student
		tempStudent,
		tempStudent1;
	
	static Course
		tempCourse;
	
//	
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			tempStudent = session.get(Student.class, tempStudentId);
						
			for(Course course : tempStudent.getCourses());	// forced loading (because fetch= FetchType.LAZY)
									
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {
			terminating();			
			}
		
		System.out.println("... tempStudent: "+tempStudent);
		System.out.println("... tempStudent's courses"+tempStudent.getCourses());
	}
}