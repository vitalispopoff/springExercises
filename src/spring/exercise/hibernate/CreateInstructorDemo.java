package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;
//import hibernate.exercise.demo.entity.Instructor;
//import hibernate.exercise.demo.entity.InstructorDetail;

public class CreateInstructorDemo {
	
	
		//	make an instructor object		
	static Instructor
		tempInstructor = new Instructor("Susan", "Public", "public@luv2code.com");

		//	make an instructorDetail object
	static InstructorDetail
		tempInstructorDetail = new InstructorDetail("https://youtube.com/user/thepublic","gaming");

		//	associate instructor with instructorDetail
	static {tempInstructor.setInstructorDetail(tempInstructorDetail);}
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			session.save(tempInstructor);			
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
	}

}