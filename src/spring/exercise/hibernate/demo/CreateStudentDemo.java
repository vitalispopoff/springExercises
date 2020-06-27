package spring.exercise.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import spring.exercise.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//	create session factory
		SessionFactory 
			factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();		

		//	create session
		Session session;
		
		try {
			session = factory.getCurrentSession();
			//	create a student object
			
			System.out.println("...creating a student object");
			Student tempStudent = new Student("Paul", "Wall", "paul@domain.com");
//			Student tempStudent = new Student("Bad", "Tone", "deaf@domain.com");
			
			//	start a transaction
			session.beginTransaction();
			
			
			//	save the student object
			System.out.println("...saving the stutent");
			
			session.save(tempStudent);
			
			
			//	commit transaction
			session.getTransaction().commit();
				
			System.out.println("...done");
			
		}
		finally {
			factory.close();
			
			System.out.println("...session closed.");
			
		}
		

	}
}