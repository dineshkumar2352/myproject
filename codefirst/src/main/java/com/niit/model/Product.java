package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	public static final long serialVersionUID = -723583058586873479L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int productID;
	@Column
	public String ProductName;
	@Column	
	public String description;
	@Column 
	public double price;
	public Product(){}
	public Product(int productID,String productName,String description,double price){
		super();
		this.productID=productID;
		this.ProductName=productName;
		this.description=description;
		this.price=price;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
