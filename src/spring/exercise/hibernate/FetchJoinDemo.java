package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

import org.hibernate.query.Query;
import java.util.List;

public class FetchJoinDemo {
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static List<Course>
	tempCourses/* = new LinkedList<>() */;
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			//	set query
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
											+ "JOIN Fetch i.courses "
											+ "where i.id=:theInstructorId",
										Instructor.class);
			
			//	set parameter for query
			query.setParameter("theInstructorId", tempInstructorId);
						
			//	executing the query
			tempInstructor = query.getSingleResult();
						
			finalizing();						
		}
		catch (Exception e) {e.printStackTrace();}
		finally {terminating();}
		
//		System.out.println("... Instructor: "+ tempInstructor);
		System.out.println("... courses: "+tempInstructor.getCourses());
	}
}