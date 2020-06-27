package spring.exercise.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import spring.exercise.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory 
			factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();		
		Session 
			session;
		int 
			studentId = 1;
		
		try {	
	
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			System.out.println("\n...getting student with id: "+studentId);
			
			Student
				myStudent = session.get(Student.class,  studentId);
			
			myStudent.setFirstName("Scooby");
						
			//	commit transaction
			session.getTransaction().commit();
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("...done");
			
		}
		finally {
			factory.close();
			
			System.out.println("...session closed.");
			
		}
		

	}
}