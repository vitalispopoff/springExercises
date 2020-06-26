package spring.exercise.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// controller method to show the initial html form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	//	controller method to process the html form
	
	@RequestMapping("/processForm")
	public String processForm() {		
		return "helloworld";
	}
	
	//	controller method to read form data and adata to the model 
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//	read the request parameter from the HTML form	
		String 
			theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		//	create the message
		String 
			result = "Yo! " + theName;
		
		//	add the message to the model		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}