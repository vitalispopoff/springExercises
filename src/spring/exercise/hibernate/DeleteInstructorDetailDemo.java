package spring.exercise.hibernate;

import hibernate.exercise.demo.entity.*;

public class DeleteInstructorDetailDemo extends Demo {

	public static void main(String[] args) {

		try {
			initializing();

			//	get the instructor detail object
			int 
				index = 2;
			InstructorDetail
				temp = session.get(InstructorDetail.class, index);
					
			// print the instructor detail object
			
			System.out.println("... instructorDetail : " + temp);				
			
			// print the associated instructor			
			
			System.out.println("... associated instructor  : " + temp.getInstructor());
			
			//	delete the instructor detail 
			
			session.delete(temp);
			System.out.println("... instructor detail "+index+" deleted");

			finalizing();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			terminating();	// no leak presented in the lesson because the method contains "session.close();" already
		}

	}

}
