//	@formatter:off

package spring.exercise.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import hibernate.exercise.demo.entity.*;

public abstract class Demo {

	private static String configFile = "hibernate.cfg.xml";
	private static Configuration config = new Configuration();
	private static SessionFactory factory = config
						.configure(configFile)
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.buildSessionFactory();
	public static Session session = factory.getCurrentSession();
	
	
	
	public static void initializing() {
		session.beginTransaction();
	}
	
	public static void finalizing() {
		session.getTransaction().commit();
	}
	
	public static void terminating() {
		session.close();
		factory.close();		
	}
	
	public static Session getSession() {return session;}
	
}

//	@formatter:on