package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class DeletePacmanCourseDemo {
		
	/**
	 * 1. get the Pacman course with given id
	 * 2. delete the Pacman course
	 * 3. ...
	 */
					
	static int 
		tempCourseId = 10,
		tempStudentId = 1;
	
	static Student
		tempStudent;
	
	static Course
		tempCourse;
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
//			tempCourse = session.get(Course.class,tempCourseId);
			
//			session.delete(tempCourse);
	
			tempStudent = session.get(Student.class, tempStudentId);
			
			System.out.println("student's (id:" + tempStudent.getId() + ") courses:" + tempStudent.getCourses());
			
			
			
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {
			terminating();			
			}
		
	}
}