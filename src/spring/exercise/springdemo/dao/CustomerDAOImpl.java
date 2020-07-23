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
		
		currentSession.saveOrUpdate(customer);		//	depending on the situation: saves new customer or updates a customer existing already in the db 									
	}

		@Override
	public Customer getCustomer(int id) {
		
		Session								//	get the current hibernate session
			currentSession = sessionFactory.getCurrentSession();
							
		Customer							//	read the object from db using primary key
			customer = currentSession.get(Customer.class, id);
		
		return customer;					//	return the retrieved customer 
	}

		@Override
	public void deleteCustomer(int id) {
		
		Session
			currentSession = sessionFactory.getCurrentSession();		
		Query
			query = currentSession.createQuery("delete from Customer where id=:customerId");

		query.setParameter("customerId", id);		
		query.executeUpdate();				//	executes the query - obvious
		
									
//		Customer							//	own solution - not that good : needs two transactions.
//			cache = currentSession.get(Customer.class, id);
		
//		currentSession.delete(cache);
	}
}