package code;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public abstract class ConnectionProcedure {

	private static String 
		configFile = "hibernate.cfg.xml";
	private static Configuration 
		config = new Configuration();
	public static SessionFactory 
		factory = config
					.configure(configFile)
					.addAnnotatedClass(Employee.class)
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
		factory.close();		
	}
	
	public static Session getSession() {return session;}
	public static SessionFactory getFactory() {return factory;}
	
}