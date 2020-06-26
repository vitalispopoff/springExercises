package spring.exercise.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
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
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVerionThree(@RequestParam("studentName") String theName, Model model) {
		
		/*
		 * // read the request parameter from the HTML form String theName =
		 * request.getParameter("studentName");
		 */	// disposable because of the @RequestParam annotation above.
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		//	create the message
		String 
			result = "Yo again! " + theName + " (v3 ya kno)";
		
		//	add the message to the model		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}