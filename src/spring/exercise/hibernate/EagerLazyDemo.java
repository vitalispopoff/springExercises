package spring.exercise.hibernate;

import static spring.exercise.connecting.ConnectionProcedure.*;

import hibernate.exercise.demo.entity.*;

public class EagerLazyDemo {
			
	static int 
		tempInstructorId = 1;
	
	static Instructor
		tempInstructor;
	
	static InstructorDetail
		tempInstructorDetail;
	
	static Course
		tempCourse1,
		tempCourse2;
	
	public static void main(String[] args) {
		
		try {
			initializing();
			
			//	retrieve the instructor 
			tempInstructor = session.get(Instructor.class, tempInstructorId);	
			
			System.out.println("... Instructor : "+tempInstructor);
			
			// closing early to force the exception
			
//			finalizing();		//contrary to predictions this one doesn't change the behaviour of session.close in terms of "HHH10001008" 

//			session.close();	// doesn't work exactly as in the course vid : no "INFO: HHH10001008"
			terminating();		// terminating both session and factory reproduces "lazyInitlalization Exception" after the "HHH10001008"

			// moving it to after the session.close is supposed to throw some nasty exception
			System.out.println("... Courses: "+ tempInstructor.getCourses());
			
			System.out.println("... done.");
			
		}
		catch (Exception e) {e.printStackTrace();}
	}

}