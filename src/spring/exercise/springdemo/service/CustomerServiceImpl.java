package spring.exercise.springdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import spring.exercise.springdemo.dao.CustomerDAO;
import spring.exercise.springdemo.entity.Customer;

	@Service
public class CustomerServiceImpl implements CustomerService {
	
		@Autowired
	private CustomerDAO
		customerDAO;
			
		@Override
		@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

		@Override
		@Transactional
	public void saveCustomer(Customer customer) {
		
		// even tho the customerServiceImpl takes care of the save method contracted by its interface, 
		//	it's only a facade, so the work is sent to the DAO interface 			
		customerDAO.saveCustomer(customer);					
	}
}