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
	
		@Autowired			//	inject the session factory
	private SessionFactory
		sessionFactory;
	
		@Override
	public List<Customer> getCustomers() {
			
		Session				//	get the current hibernate session 
			currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> 	// 	create a query
			query = currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer>		//	execute the query 
			customers = query.getResultList();
		
		return customers;	//	return result list from the query 
	}

		@Override
	public void saveCustomer(Customer customer) {

		// the saveCustomer method is actually processed here as the chain of responsibility ends in the DAOImpl class :
					
		//	get current hibernate session
		Session
			currentSession = sessionFactory.getCurrentSession();
			
		//	eventually save the customer to the db
		currentSession.save(customer);
									
		}
}