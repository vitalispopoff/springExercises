package spring.exercise.hibernate.demo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import spring.exercise.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//	create session factory
		SessionFactory 
			factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();		

		//	create session
		Session session = factory.getCurrentSession();
		
		try {
			
			List<Student> 
				theStudents;

			//	start a transaction
			session.beginTransaction();
			
			//	query students			
			theStudents = session.createQuery("from Student").getResultList();

			displayStudents(theStudents);
			
			//	query students by lastName
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			displayStudents(theStudents);
			
			//	query students by lastName OR firstName
			
			theStudents = session.createQuery("from Student s where s.firstName='John' OR s.lastName='Tone'").getResultList();
			
			displayStudents(theStudents);
			
			// query students by lastName AND firstName
			
			theStudents = session.createQuery("from Student s where s.firstName='John' AND s.lastName='Tone'").getResultList();
			
			displayStudents(theStudents);
			
			//	query students by email part
			
			theStudents = session.createQuery("from Student s where s.email LIKE  '%duck.com'").getResultList();
			
			displayStudents(theStudents);
						
		}
		finally {
			factory.close();			
		}		
	}

	private static void displayStudents(List<Student> theStudents) {
		System.out.println("-----------");
		for(Student tempStudent : theStudents) System.out.println(tempStudent);
		System.out.println("-----------");
	}
}