package spring.exercise.springdemo.dao;

import java.util.List;

import spring.exercise.springdemo.entity.Customer;

public interface CustomerDAO {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);	
	
}