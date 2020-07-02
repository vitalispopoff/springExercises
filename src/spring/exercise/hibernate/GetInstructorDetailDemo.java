package spring.exercise.hibernate;

import hibernate.exercise.demo.entity.*;

public class GetInstructorDetailDemo extends Demo {

	public static void main(String[] args) {

		try {
			initializing();

			//	get the instructor detail object
			int 
				index = 23;
			InstructorDetail
				temp = session.get(InstructorDetail.class, index);
					
			// print the instructor detail object
			
			System.out.println("... instructorDetail : " + temp);				
			
			// print the associated instructor			
			
			System.out.println("... associated instructor  : " + temp.getInstructor());
			

			finalizing();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			terminating();
		}

	}

}
