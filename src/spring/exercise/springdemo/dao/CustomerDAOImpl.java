package spring.exercise.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import spring.exercise.springdemo.entity.Customer;
	
	@Repository
public class CustomerDAOImpl implements CustomerDAO {

	/**
	 *  1. inject the session factory
	 */
	
		@Autowired
	private SessionFactory
		sessionFactory;
	
		@Override
		@Transactional
	public List<Customer> getCustomers() {
			
		/**
		 * 1. get the current hibernate session
		 * 2. create a query
		 * 3. execute the query
		 * 4. return result list from the query 
		 */

		Session 
			currentSession = sessionFactory.getCurrentSession();
		Query<Customer> 
			query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> 
			customers = query.getResultList();
		
		return customers;
	}
}