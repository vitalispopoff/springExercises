package spring.exercise.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/*
	 * add an initBinder to convert trim input strings remove leading and trailing
	 * whitespace resolve issue for our validation
	 */

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		theModel.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		//	System.out.println("... lastName |" + theCustomer.getLastName() + "|");
		System.out.println("\n____________________\n\n");
		System.out.println("...Binding resuld: " + theBindingResult);
		System.out.println("\n____________________\n\n");
		
		return theBindingResult.hasErrors() ? "customer-form" : "customer-confirmation";
	}
}