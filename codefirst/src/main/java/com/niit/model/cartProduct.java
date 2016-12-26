package com.niit.model;

import java.io.Serializable;

public class cartProduct implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Product product;
	private int qty;
	private double totalCost;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double d) {
		this.totalCost = d;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
