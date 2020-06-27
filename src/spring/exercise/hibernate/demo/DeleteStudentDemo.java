package spring.exercise.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import spring.exercise.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory
			factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session
			session;
		String
			email = "foo@gmail.com";
		
		try {
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			session.createQuery("delete from Student where email='"+email+"'").executeUpdate();
			session.createQuery("delete from Student").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}		
	}
}