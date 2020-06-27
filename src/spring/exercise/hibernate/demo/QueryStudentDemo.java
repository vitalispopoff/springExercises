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

			//	start a transaction
			session.beginTransaction();
			
			//	query students
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//	display students

//			displayStudents(theStudents);
			
			System.out.println("-----------");
			
			// query students : lastName = 'Doe'			
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			//	commit transaction
			session.getTransaction().commit();
			
			displayStudents(theStudents);
			
			System.out.println("-----------");
				
			System.out.println("...done");
			
		}
		finally {
			factory.close();
			
			System.out.println("...session closed.");
			
		}
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) System.out.println("\n"+tempStudent);
	}
}