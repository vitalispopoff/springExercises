package spring.exercise.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//	create new student object
		Student theStudent = new Student();
		
		//	add student object to the model		
		theModel.addAttribute("student", theStudent);
		
		return "student-form";		
	}	
}