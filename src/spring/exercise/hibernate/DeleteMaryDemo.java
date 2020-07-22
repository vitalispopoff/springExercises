package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class DeleteMaryDemo {
		
	/**
	 * 1. get Mary by id
	 * 2. remove Mary from DB
	 * 3. list the courses
	 */
					
	
	static int 
		tempStudentId = 2;
	
	static Student
		tempStudent;
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			tempStudent = session.get(Student.class, tempStudentId);
			
			session.delete(tempStudent);
						
			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {
			terminating();			
			}
				
	}
}