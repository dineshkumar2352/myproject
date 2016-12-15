package com.niit.dao;



import java.util.List;

import com.niit.model.Customer;



public interface CustomerDao {
 void addCustomer(Customer cust);
 void editCustomer(Customer cust);
 void deleteCustomer(int custID);
 Customer getCustomer(int custID);
 List<Customer> viewCustomer();
}
