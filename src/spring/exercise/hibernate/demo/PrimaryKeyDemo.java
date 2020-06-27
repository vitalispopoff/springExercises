package spring.exercise.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import spring.exercise.demo.entity.Student;

public class PrimaryKeyDemo {
	
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
					
//			Student tempStudent  = new Student("Paul", "Wall", "paul@domain.com");
			Student tempStudent1 = new Student("John", "Doe", "john@domain.com");
			Student tempStudent2 = new Student("Marry", "Public", "mary@domain.com");
			Student tempStudent3 = new Student("Bon", "Tone", "tone@domain.com");
			
			session.beginTransaction();					
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();				
			
		}
		finally {factory.close();}		
	}
}