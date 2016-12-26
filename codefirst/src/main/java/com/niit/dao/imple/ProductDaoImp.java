package com.niit.dao.imple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;

@Repository
public class ProductDaoImp implements ProductDao {

	@Autowired
	SessionFactory sf;
	
	@Transactional
	public void addProduct(Product prod) {
		Session session = sf.openSession();
		Transaction tx = (Transaction)session.beginTransaction();
		session.saveOrUpdate(prod);
		tx.commit();
		session.close();

	}

	@Transactional
	public void editProduct(Product prod) {
		Session session = sf.openSession();
		Transaction tx = (Transaction)session.beginTransaction();
    	session.update(prod);
    	tx.commit();
    	session.close();

	}

	@Transactional
	public void deleteProduct(int productID) {
		Session session = sf.openSession();
		Transaction tx = (Transaction)session.beginTransaction();
    	session.delete(getProduct(productID));;
    	tx.commit();
    	session.close();

	}

	@Transactional
	public Product getProduct(int productID) {
    	return (Product)sf.getCurrentSession().get(Product.class, productID);
	}

	@Transactional
	public List<Product> viewProducts() {
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Product> productList = session.createQuery("from Product").list();
		return productList;
		//return sf.getCurrentSession().createQuery("from Customer").list();
	}
    @Transactional
	public void addShipAddr(ShippingAddress shipAddr) {
		
		Session session = sf.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.saveOrUpdate(shipAddr);
		transaction.commit();
		
	}
    @Transactional
    public void saveAddr(ShippingAddress shipAddr) {
		//productDao.addShipAddr(shipAddr);
		
	}

}
