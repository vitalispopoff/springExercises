//	@formatter:off

package spring.exercise.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.exercise.demo.entity.Instructor;
import hibernate.exercise.demo.entity.InstructorDetail;

public class CreateDemo {
	
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
		
		SessionFactory 
			factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)		// it seems like we can add more than one, just like with StringBuilder
						.buildSessionFactory();
		Session
			session = factory.getCurrentSession();
		
//	@formatter:on

		try {

			Instructor
				tempInstructor;
			
			session.beginTransaction();
			
			session.delete(tempInstructor = session.get(Instructor.class, 1));
			
			

//			for(Instructor instructor : instructors) session.save(instructor);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}