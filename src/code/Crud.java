package code;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public abstract class Crud {
	
	private static String
		configFile = "hibernate.cfg.xml";	
	private static SessionFactory
		factory;
	private static Session
		session;
	private Configuration
		configuration = new Configuration().configure(configFile);

	public static void main(String[] args) {
		
		System.out.println(configFile);
	}
	
	
}