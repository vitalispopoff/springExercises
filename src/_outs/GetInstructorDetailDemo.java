package _outs;

import hibernate.exercise.demo.entity.*;
import spring.exercise.connecting.ConnectionProcedure;

public class GetInstructorDetailDemo extends ConnectionProcedure {

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
			terminating();	// no leak presented in the lesson because the method contains "session.close();" already
		}

	}

}
