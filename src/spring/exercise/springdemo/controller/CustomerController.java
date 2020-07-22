package spring.exercise.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.exercise.springdemo.dao.CustomerDAO;
import spring.exercise.springdemo.entity.Customer;

	@Controller
	@RequestMapping("/customer")
public class CustomerController {		
		
		@Autowired				//	injecting the customer dao
	private CustomerDAO 
		customerDAO;
	
		@RequestMapping("/list")
	public String listCustomers (Model model) {
			
		
		//	get customers from the dao
		List<Customer>		 
			customers = customerDAO.getCustomers();
			
		//	add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}
}