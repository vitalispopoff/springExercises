//	@formatter:off

package spring.exercise.connecting;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import hibernate.exercise.demo.entity.*;

public abstract class ConnectionProcedure {

	private static String 
		configFile = "hibernate.cfg.xml";
	private static Configuration 
		config = new Configuration();
	public static SessionFactory 
		factory = config
					.configure(configFile)
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.buildSessionFactory();
	public static Session 
		session = factory.getCurrentSession();
	
//	
	
	public static void initializing() {
		session.beginTransaction();
	}
	
	public static void finalizing() {
		session.getTransaction().commit();
	}
	
	public static void terminating() {
		session.close();
//		factory.close();		
	}
	
	public static Session getSession() {return session;}
	public static SessionFactory getFactory() {return factory;}
	
}

//	@formatter:on