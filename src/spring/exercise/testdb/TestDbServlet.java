package spring.exercise.testdb;

import java.io.*;
import java.sql.*;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


//  Servlet implementation class TestDbServlet
  
	@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

	private static final long 
		serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 1. setup connection variables
		 * 2. get connection to the db
		 */
		
		String 
			user = "springstudent",
			pass = "springstudent",
			jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=CET",
			driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			PrintWriter
				out = response.getWriter();
			out.println("connectin to the database: "+jdbcUrl);
			
			Class.forName(driver);
			
			Connection
				myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("... connected");
			
			myConn.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);	// this one interesting, innit?
		}
	}
}