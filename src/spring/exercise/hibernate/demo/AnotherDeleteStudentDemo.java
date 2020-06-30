package spring.exercise.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.exercise.demo.entity.Student;

public class AnotherDeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory
			factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		Session
			session;
		Student
			myStudent;
		int
			studentId = 3;
		
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			myStudent = session.get(Student.class, studentId);
			
			System.out.println("..."+myStudent);
			
			session.delete(myStudent);
			
			session.getTransaction().commit();
			
			
			
		}
		finally {
			factory.close();
		}
	}
}