package spring.exercise.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.exercise.springdemo.entity.Customer;
import spring.exercise.springdemo.service.CustomerService;

	@Controller
	@RequestMapping("/customer")
public class CustomerController {		
		
		@Autowired				//	injecting the customerService instead of the customerDAO, as the transaction layer has been moved to the Service package
	private CustomerService 
		customerService;
		
//		
	
	@GetMapping("/list")
	public String listCustomers (Model model) {
					
		//	get customers from the dao through the service layer
		List<Customer>		 
			customers = customerService.getCustomers();
			
		//	add the customers as an attribute to the model
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
			
			// redirects to the "/customer/list" address forcing the listCustomers method.
		return "redirect:/customer/list";
	}
		
	@GetMapping("/showFormForUpdate")
	public String shoFromForUpdate(
		@RequestParam("customerId") 
		int id, 
		Model model) {
			
			// get the customer via Service layer
			Customer
			customer = customerService.getCustomer(id);
									
			// set customer as model attribute to pre-populate the form
			model.addAttribute("customer", customer);
			
			// return the address to the form 			
			return "customer-form";
	}
		
	@GetMapping("/delete")
	public String deleteCustomer(
		@RequestParam("customerId") int id) {
		
			// delete the customer via the service layer
			customerService.deleteCustomer(id);
				
			// forces refreshing the list by calling the listCustomers method with an address 
			return "redirect:/customer/list";
	}
		
	@GetMapping("/search")
	public String searchCustomers(
		@RequestParam("theSearchName")
		String searchName, Model model) {
		
			List<Customer>
				customers = customerService.searchCustomers(searchName);
			
			model.addAttribute("customers", customers);
			
			return "list-customers";
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	