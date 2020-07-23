package spring.exercise.springdemo.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import spring.exercise.springdemo.entity.Customer;
	
	@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
		@Autowired							//	inject the session factory
	private SessionFactory
		sessionFactory;
		
//		
	
		@Override
	public List<Customer> getCustomers() {
			
		Session								//	get the current hibernate session 
			currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> 					// 	create a sorting-by-lastName query 
			query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer>						//	execute the query 
			customers = query.getResultList();
		
		return customers;					//	return result list from the query 
	}
	
		@Override							// the saveCustomer() is finally processed here :
	public void saveCustomer(Customer customer) {
							
		Session								//	get current hibernate session
			currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(customer);		//	eventually save the customer to the db									
	}

		@Override
	public Customer getCustomer(int id) {
		
		Session								//	get the current hibernate session
			currentSession = sessionFactory.getCurrentSession();
							
		Customer							//	read the object from db using primary key
			customer = currentSession.get(Customer.class, id);
		
		return customer;					//	return the retrieved customer 
	}
}