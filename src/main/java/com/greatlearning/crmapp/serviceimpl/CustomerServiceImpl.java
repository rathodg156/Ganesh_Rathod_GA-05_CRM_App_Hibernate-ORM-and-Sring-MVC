package com.greatlearning.crmapp.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.crmapp.model.Customer;
import com.greatlearning.crmapp.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;
	private Session session;
	
  @Autowired // used to import the class from package
	
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession();
  	}
  		@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
		tx.commit();
		return customers;
	}
  		@Transactional
	public Customer findById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}
  		@Transactional
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}
  		@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();
	}

}