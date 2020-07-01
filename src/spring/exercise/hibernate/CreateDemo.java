//	@formatter:off

package spring.exercise.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import hibernate.exercise.demo.entity.*;

public class CreateDemo {

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
			
			//	create objects
			
			Instructor
				tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail
				tempDetail = new InstructorDetail("http://www.luv2code.com/youtube", "coding");
			
			//	associate the objects
			
			

			session.beginTransaction();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}