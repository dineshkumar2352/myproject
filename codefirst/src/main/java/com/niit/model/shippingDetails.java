package com.niit.model;

import java.io.Serializable;

public class shippingDetails implements Serializable {

	
	private static final long serialVersionUID = 4393641856701021973L;
	private ShippingAddress shipAddr;
	private Customer cust;

	public ShippingAddress getShipAddr() {
		return shipAddr;
	}

	public void setShipAddr(ShippingAddress shipAddr) {
		this.shipAddr = shipAddr;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

}
