package com.niit.dao.imple;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;


@Repository
public class CustomerDaoImp implements CustomerDao {

	@Autowired
	SessionFactory sf;
	
	@Transactional
	public void addCustomer(Customer cust) {
		Session session = sf.openSession();
		Transaction tx = (Transaction)session.beginTransaction();
		session.saveOrUpdate(cust);
		tx.commit();
		session.close();
	}
	@Transactional
    public void editCustomer(Customer cust){
		Session session = sf.openSession();
		Transaction tx = (Transaction)session.beginTransaction();
    	session.update(cust);
    	tx.commit();
    	session.close();
    }
	@Transactional
    public void deleteCustomer(int custID){
		Session session = sf.openSession();
		Transaction tx = (Transaction)session.beginTransaction();
    	session.delete(getCustomer(custID));;
    	tx.commit();
    	session.close();
    }
	@Transactional
    public Customer getCustomer(int custID)
    {
    	return (Customer)sf.getCurrentSession().get(Customer.class, custID);
    }
	
    @Transactional
	public List<Customer> viewCustomer() {
    	Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> custList = session.createQuery("from Customer").list();
		return custList;
		//return sf.getCurrentSession().createQuery("from Customer").list();
	}

	
}
