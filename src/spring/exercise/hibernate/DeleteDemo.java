//	@formatter:off

package spring.exercise.hibernate;

import org.hibernate.*;

import hibernate.exercise.demo.entity.*;

public class DeleteDemo extends Demo {
	
	public static void main(String[] args) {
		
		try {
	
			initializing();
			// start a transaction
//			session.beginTransaction();
	
			// get instructor by primary key
			int 
				index = 1;
			Instructor 
				temp = session.get(Instructor.class, index);
			
			//	delete the instructor
			if(temp != null) {
				session.delete(temp);
				System.out.println("... entity deleted : "+temp);
			}
			
			finalizing();
			// commit transaction
//			session.getTransaction().commit();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			terminating();
//			session.close();
//			factory.close();
		}
	}

//	@formatter:on

	
}