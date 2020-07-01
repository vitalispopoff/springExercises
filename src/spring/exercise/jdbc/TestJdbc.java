package spring.exercise.jdbc;

import java.sql.*;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		String 
			jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false&serverTimezone=CET",
			user = "hbstudent",
			pass = "hbstudent";
		
		try {
			System.out.println("...connection to database "+jdbcUrl);
			
			Connection
				myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("... connection succeeded.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
}