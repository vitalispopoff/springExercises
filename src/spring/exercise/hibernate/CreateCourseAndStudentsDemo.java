package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class CreateCourseAndStudentsDemo {
		
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
		tempCourse1 = new Course("Rubik's Cube - How To Speed Cube"),
		tempCourse2 = new Course("Atari 2600 - Game Development"),
		tempCourse;
	
//	
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			tempStudent = session.get(Student.class, tempStudentId);
						
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
						
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {
			terminating();			
			}
	}
}