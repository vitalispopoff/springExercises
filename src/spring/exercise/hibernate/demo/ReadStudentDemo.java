package spring.exercise.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import spring.exercise.demo.entity.Student;

public class ReadStudentDemo {

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
			//	create a student object
			System.out.println("...creating a student object");
			Student tempStudent = new Student("Duffy", "Duck", "duffy@duck.com");
			
			//	start a transaction
			session.beginTransaction();
						
			//	save the student object
			System.out.println("...saving the stutent\n"+tempStudent);
					
			session.save(tempStudent);
						
			//	commit transaction
			session.getTransaction().commit();
						
//	retrieve
			
			//	find out the student's id : PK
			System.out.println("...student saved. id : "+tempStudent.getId());
			
			//	get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			//	retrieve student based on the id: PK
			System.out.println("\nGetting studend with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("... get complete: "+myStudent);
			
			//	commit the transaction
			session.getTransaction().commit();
							
			System.out.println("...done");
			
		}
		finally {
			factory.close();
			
			System.out.println("...session closed.");
			
		}
		

	}
}