package com.niit.dao;

import java.util.List;

import com.niit.model.Product;
import com.niit.model.ShippingAddress;

public interface ProductDao {
	void addProduct(Product prod);
	void editProduct(Product prod);
	void deleteProduct(int productID);
	Product getProduct(int productID);
	List<Product> viewProducts();
	void addShipAddr(ShippingAddress shipAddr);
	void saveAddr(ShippingAddress shipAddr);
}
