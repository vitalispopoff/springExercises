package spring.exercise.springdemo.service;

import java.util.List;

import spring.exercise.springdemo.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);
	

}