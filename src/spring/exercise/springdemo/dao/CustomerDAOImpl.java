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
		@Transactional
	public List<Customer> getCustomers() {
			
		Session				//	get the current hibernate session 
			currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> 	// 	create a query
			query = currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer>		//	execute the query 
			customers = query.getResultList();
		
		return customers;	//	return result list from the query 
	}
}