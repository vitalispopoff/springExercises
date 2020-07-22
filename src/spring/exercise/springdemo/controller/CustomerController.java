package spring.exercise.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.exercise.springdemo.entity.Customer;
import spring.exercise.springdemo.service.CustomerService;

	@Controller
	@RequestMapping("/customer")
public class CustomerController {		
		
		@Autowired				//	injecting the customerService instead of the customerDAO, as the transaction layer has been moved to the Service package
	private CustomerService 
		customerService;
	
		@GetMapping("/list")
	public String listCustomers (Model model) {
			
		
		//	get customers from the dao through the service layer
		List<Customer>		 
			customers = customerService.getCustomers();
			
		//	add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}
		
		@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
			
		// create model attribute to bind form data
		Customer
			customer = new Customer();
		
		model.addAttribute("customer", customer);
			
			
			return "customer-form";
		}
		
		@PostMapping("/saveCustomer")
	public String saveCustomer(
			@ModelAttribute("customer") 
		Customer customer) {
			
			// the method delegates the work to the service layer : CustomerService interface
			customerService.saveCustomer(customer);	
			
			return "redirect:/customer/list";
		}
		
}