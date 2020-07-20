//	@formatter:off

package _outs;

import java.util.ArrayList;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

import hibernate.exercise.demo.entity.*;
import spring.exercise.connecting.ConnectionProcedure;

public class CreateDemo extends ConnectionProcedure{
	
	static ArrayList<Instructor> 
		instructors = new ArrayList<>();
	static ArrayList<InstructorDetail> 
		instructorDetails = new ArrayList<>();
	
	static {
		//	create main table entities		
		instructors.add(new Instructor("Chad", "Darby", "darby@luv2code.com"));
		instructors.add(new Instructor("Madhu", "Patel", "madhu@luv2code.com"));
		
		//	create join table entities		
		instructorDetails.add(new InstructorDetail("http://www.luv2code.com/youtube", "coding"));
		instructorDetails.add(new InstructorDetail("http://www.youtube.com/user/madhupatel", "playing the guitar"));
		
		//	associate entities		
		for(int i = 0; i < instructors.size(); i++) {
			instructors.get(i).setInstructorDetail(instructorDetails.get(i));
		}
	}

	
	
	public static void main(String[] args) {
		
//		Demo demo = new CreateDemo();
		
		try {
			
			initializing();
//			session.beginTransaction();						

//			for(Instructor instructor : instructors) session.save(instructor);

			finalizing();
//			session.getTransaction().commit();

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			terminating();
//			session.close();
//			factory.close();
		}

	}
}

//@formatter:on