package _outs;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;
//import hibernate.exercise.demo.entity.Instructor;
//import hibernate.exercise.demo.entity.InstructorDetail;

public class CreateInstructorDemo {
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	public static void main(String[] args) {
		
		try {
			initializing();
					
			//	saving the tempInstructor
			session.save(tempInstructor);
			
//			finalizing();
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}

}