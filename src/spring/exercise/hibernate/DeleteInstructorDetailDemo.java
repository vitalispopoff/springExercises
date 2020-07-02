package spring.exercise.hibernate;

import hibernate.exercise.demo.entity.*;

public class DeleteInstructorDetailDemo extends Demo {

	public static void main(String[] args) {

		try {
			initializing();

			//	get the instructor detail object
			int 
				index = 1;
			InstructorDetail
				temp = session.get(InstructorDetail.class, index);								
			
			//	break the association InstructorDetail > Instructor		
			
			temp.getInstructor().setInstructorDetail(null);			
			
			System.out.println("... temp : "+temp);
			
			//	delete the instructor detail		
									
			session.delete(temp);
			
			finalizing();
			
			System.out.println("... instructor detail "+index+" deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			terminating();
		}

	}

}
